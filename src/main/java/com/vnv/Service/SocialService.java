package com.vnv.Service;


import com.vnv.Entity.User;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public abstract class SocialService {

    public abstract JSONObject getConfig();
    public abstract JSONObject login(String code, String state, HttpSession session);
    protected abstract boolean validate(String iss, String aud, long exp);
    protected abstract JSONObject getTokens(String code, String state);
    protected abstract User getUserInfo(String access_token);
    protected abstract JSONObject addSocialFriends(User user, String access_token);
    protected abstract List<User> retrieveFriends(String mail, String access_token) throws IOException, ParserConfigurationException, SAXException;

}
