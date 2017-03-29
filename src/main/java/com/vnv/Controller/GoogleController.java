package com.vnv.Controller;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Model.Http;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GoogleController {

    private static Logger log = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRelDao userRelDao;

    @RequestMapping(value="/gconnect")
    String gconnect(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParserConfigurationException, SAXException {
        log.debug(state);
        log.debug(code);
        if (!state.equals(session.getAttribute("state"))) {
            log.debug(session.getAttribute("state").toString());
            return "Wrong session";
        }

        List<NameValuePair> params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("code", code));
        params.add(new BasicNameValuePair("client_id", "707063193538-lcm9405hr187ncpl3rcv4q5ts2po42tc.apps.googleusercontent.com"));
        params.add(new BasicNameValuePair("client_secret", "6YdUzTw8_UhzKe6qGOPyQXp7"));
        params.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/gconnect"));
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));

        JSONObject response = Http.post("https://www.googleapis.com/oauth2/v4/token", params);

        String access_token = response.getString("access_token");
        String id_token = response.getString("id_token");
        log.debug(access_token);
        log.debug(id_token);

        params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("id_token", id_token));

        response = Http.post("https://www.googleapis.com/oauth2/v3/tokeninfo", params);
        String iss = response.getString("iss");
        String sub = response.getString("sub");
        String aud = response.getString("aud");
        long exp = response.getLong("exp");
        if (!validate(iss, aud, exp)) {
            return "Something went wrong. Please try again!";
        }
        User user = new User();
        user.setGoogleId(sub);
        user.setMail(response.getString("email"));
        user.setMailValid(response.getBoolean("email_verified"));
        user.setName(response.getString("name"));
        user.setFirstName(response.getString("given_name"));
        user.setLastName(response.getString("family_name"));
        user.setPicPath(response.getString("picture"));

        //TODO check if user is registered (by googleid), if ->login, if not-> register user, if account already exists for that email there should be some possibility to combine them (IDH)

        // gets Friends and send request
        List<User> gfriends = getFriends(user.getMail(), access_token);
        for (User gfriend:gfriends) {
            userRelDao.addRequest(user, gfriend);
        }

        return user.toJSON().toString();
    }

    public List<User> getFriends(String mail, String access_token) throws IOException, ParserConfigurationException, SAXException {
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

    public boolean validate(String iss, String aud, long exp) {
        if (new Date().getTime() < exp) {
            log.debug("Token expired");
            return false;
        }
        if (!"707063193538-lcm9405hr187ncpl3rcv4q5ts2po42tc.apps.googleusercontent.com".equals(aud)) {
            log.debug("Token not audienced to vnv");
            return false;
        }
        if (!"https://accounts.google.com".equals(iss)) {
            log.debug("Token not issued by google");
            return false;
        }
        return true;
    }
}

