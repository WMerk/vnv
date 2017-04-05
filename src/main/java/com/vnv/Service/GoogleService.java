package com.vnv.Service;


import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Model.ErrorMessage;
import com.vnv.Model.Http;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoogleService extends SocialService {

    private static Logger log = LoggerFactory.getLogger(GoogleService.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRelDao userRelDao;

    @Value("${social.google.client_id}")
    private String client_id;
    @Value("${social.google.client_secret}")
    private String client_secret;
    @Value("${social.google.configuration_endpoint}")
    private String configuration_endpoint;

    public String redirect_uri = "https://dhbw-projekt.data.kit.edu/gconnect";
    public String debug_redirect_uri = "http://localhost:8080/";

    private String grant_type = "authorization_code";
    public String scope = "openid email profile https://www.googleapis.com/auth/contacts.readonly";
    public String response_type = "code";
    public String display = "popup";

    public String iss;
    public String auth_endpoint;
    private String userinfo_endpoint;
    private String token_endpoint;
    private String tokeninfo_endpoint = "https://www.googleapis.com/oauth2/v3/tokeninfo";

    @PostConstruct
    private void retrieveConfig() throws IOException {
        JSONObject config = new JSONObject(Http.get(configuration_endpoint));
        auth_endpoint = config.getString("authorization_endpoint");
        userinfo_endpoint = config.getString("userinfo_endpoint");
        token_endpoint = config.getString("token_endpoint");
        iss = config.getString("issuer");
    }

    @Override
    public JSONObject getConfig() {
        JSONObject config = new JSONObject();
        config.put("iss", iss);
        config.put("client_id", client_id);
        config.put("auth_endpoint", auth_endpoint);
        config.put("response_type", response_type);
        config.put("scope", scope);
        config.put("redirect_uri", redirect_uri);
        config.put("display", display);
        return config;
    }

    @Override
    public JSONObject login(String code, String state, String redirect_uri, HttpSession session) {
        if (!state.equals(session.getAttribute("state"))) {
            return new JSONObject(ErrorMessage.DefaultError);
        }
        JSONObject tokenJson = getTokens(code, state);
        if (tokenJson.has("error")) {
            log.error(tokenJson.toString());
            return tokenJson;
        }
        String access_token = tokenJson.getString("access_token");
        String id_token = tokenJson.getString("id_token");
        log.debug("Access token: {}",access_token);
        log.debug("Id token: {}", id_token);

        if (!validateToken(id_token)) {
            log.debug("Could not validate token");
            return new JSONObject(ErrorMessage.DefaultError);
        }

        User user = getUserInfo(access_token);
        if (user==null)
            return new JSONObject(ErrorMessage.DefaultError);
        if (userDao.getUserByGoogleId(user.getGoogleId())!=null) {
            //login
            user.setSessionId(session.getId());
            userDao.updateUser(user);
        } else {
            //register
            log.debug("Registering google user {}", user);
            userDao.insertUserToDb(user);
            user = userDao.getUserByMail(user.getMail());
            if (user==null) {
                return new JSONObject(String.format(ErrorMessage.Error, "could not register user"));
            }
            log.debug("User {} successfully added to DB", user);
            log.debug("Adding user to graphDB");
            userRelDao.addUser(user);

            JSONObject json = addSocialFriends(user, access_token);

            /*
            try {
                MailService.sendEmail(user.getMail(), "Willkommen zu vnv", MailMessage.getGwelcome(user.getName()));
            } catch (MessagingException e) {
                log.error(e.getMessage());
            }
            */

            if (json.has("error"))
                return json;
        }

        return user.toJSON();
    }



    @Override
    protected boolean validate(String iss, String aud, long exp) {
            if (new Date().getTime() < exp) {
                log.debug("Token expired");
                return false;
            }
            if (!client_id.equals(aud)) {
                log.debug("Token not audienced to vnv");
                return false;
            }
            if (!iss.equals(iss)) {
                log.debug("Token not issued by google");
                return false;
            }
            return true;
    }

    @Override
    protected JSONObject getTokens(String code, String state) {
        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("code", code));
        params.add(new BasicNameValuePair("client_id", client_id));
        params.add(new BasicNameValuePair("client_secret", client_secret));
        params.add(new BasicNameValuePair("redirect_uri", redirect_uri));
        params.add(new BasicNameValuePair("grant_type", grant_type));

        try {
            JSONObject response = Http.post(token_endpoint, params);
            return response;
        } catch (IOException e) {
            return new JSONObject(ErrorMessage.DefaultError);
        }
    }

    private boolean validateToken(String id_token) {
        try {
            List<NameValuePair> params = new ArrayList<>(2);
            params.add(new BasicNameValuePair("id_token", id_token));
            JSONObject response = Http.post(tokeninfo_endpoint, params);
            if (response.has("error")) {
                log.error(response.toString());
                return false;
            }
            String iss = response.getString("iss");
            String aud = response.getString("aud");
            long exp = response.getLong("exp");
            return validate(iss, aud, exp);
        } catch(IOException e) {
            return false;
        }
    }

    @Override
    protected User getUserInfo(String access_token) {
        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("access_token", access_token));
        try {
            //JSONObject response = Http.post(userinfo_endpoint, params);
            JSONObject response = new JSONObject(Http.get(String.format("%s?access_token=%s",userinfo_endpoint,access_token)));
            if (response.has("error")) {
                log.error(response.toString());
                return null;
            }
            User user = new User();
            user.setGoogleId(response.getString("sub"));
            user.setMail(response.getString("email"));
            user.setMailValid(response.getBoolean("email_verified"));
            user.setName(response.getString("name"));
            user.setFirstName(response.getString("given_name"));
            user.setLastName(response.getString("family_name"));
            if (response.has("picture"))
                user.setPicPath(response.getString("picture"));
            if (response.has("phone_number"))
                user.setPhone(response.getString("phone_number"));
            if (response.has("phone_number_verified"))
                user.setPhoneValid(response.getBoolean("phone_number_verified"));
            log.debug(user.toString());
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
    }
    }

    @Override
    protected JSONObject addSocialFriends(User user, String access_token) {
        try {
            List<User>  gfriends = retrieveFriends(user.getMail(), access_token);
            int i=0;
            for (User gfriend:gfriends) {
                userRelDao.addRequest(user, gfriend);
                i++;
            }
            JSONObject json = new JSONObject();
            json.put("addedFriends", i);
            json.put("googleFriends", gfriends.size());
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject(String.format(ErrorMessage.Error, "error while retrieving friend list"));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return new JSONObject(String.format(ErrorMessage.Error, "error while parsing friend list"));
        }
    }

    @Override
    protected List<User> retrieveFriends(String mail, String access_token) throws IOException, ParserConfigurationException, SAXException {
        Header header = new BasicHeader("Authorization", "Bearer "+access_token);
        String url = String.format("https://www.google.com/m8/feeds/contacts/%s/full",mail);
        String response = Http.get(url, header);

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new InputSource(new StringReader(response)));

        List<User> gfriends = new ArrayList<>();
        NodeList mailNodes = doc.getElementsByTagName("gd:email");
        for(int i=0; i< mailNodes.getLength(); i++) {
            Element element = (Element) mailNodes.item(i);
            User friend = userDao.getUserByMail(element.getAttribute("address"));
            if (friend!=null) {
                gfriends.add(friend);
            }
        }
        return gfriends;
    }


    @PostConstruct
    @Profile("debug")
    private void changeRedirectUri() {
        redirect_uri = debug_redirect_uri;
    }

}
