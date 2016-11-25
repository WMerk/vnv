package com.vnv.Controller;

import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController

public class FacebookController {

    @Value("${spring.social.facebook.appId}")
    String client_id;
    @Value("${spring.social.facebook.appSecret}")
    String app_secret;

    @Autowired
    UserDao  userDao;

    @RequestMapping(value = "/connect/facebook", method = RequestMethod.GET)
    public String facebook(@RequestParam String code) throws IOException {

        JSONObject userToken = HttpGetJson("https://graph.facebook.com/v2.8/oauth/access_token?client_id=%s&client_secret=%s&code=%s&redirect_uri=http://localhost:8080/connect/facebook",
                new String[] {client_id, app_secret, code});

        JSONObject appToken = HttpGetJson("https://graph.facebook.com/v2.8/oauth/access_token?client_id=%s&client_secret=%s&grant_type=client_credentials",
                new String[] {client_id, app_secret});

        String id = HttpGetJson("https://graph.facebook.com/debug_token?input_token=%s&access_token=%s",
                new String[] {userToken.getString("access_token"), appToken.getString("access_token")}
        ).getJSONObject("data").getString("user_id");

        JSONObject data = HttpGetJson("https://graph.facebook.com/%s?fields=email,first_name,last_name,id&access_token=%s",
                new String[] {id, userToken.getString("access_token")});

        User user = userDao.getUserByFacebookId(id);
        if (user==null) {
            //register
            user = new User();
            user.setFirstName(data.getString("first_name"));
            user.setLastName(data.getString("last_name"));
            user.setMail(data.getString("email"));
            user.setFacebookId(data.getString("id"));
            user.setMailValid(true);
            user.setPicPath(HttpGetJson("https://graph.facebook.com/%s/picture?redirect=0&access_token=%s",
                    new String[]{id, userToken.getString("access_token")})
                    .getJSONObject("data").getString("url"));

            String answer = userDao.insertUserToDb(user).toJSON().toString();
            System.out.println(answer);
            //TODO get friends, add friends
            return answer;
        } else {
            return user.toJSON().toString();
        }

    }

    private String HttpGet(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection urlCon = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        urlCon.getInputStream()));
        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            result += inputLine;
        }
        in.close();
        return result;
    }

    private JSONObject HttpGetJson(String url, String[] params) throws IOException {
        return new JSONObject(HttpGet(String.format(url, params)));
    }



}
