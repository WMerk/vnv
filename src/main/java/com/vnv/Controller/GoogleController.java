package com.vnv.Controller;

import com.vnv.Service.GoogleService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
public class GoogleController {

    private static Logger log = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    GoogleService gService;



    @RequestMapping(value="/gconnect")
    String gconnect(@RequestParam String code, @RequestParam String state, HttpSession session) {

        JSONObject json = gService.login(code, state, session);
        log.debug(json.toString());
        return json.toString();
    }

    @RequestMapping("/gconfig")
    public String getGoogleConfig(HttpSession session) {
        String state = new BigInteger(130, new SecureRandom()).toString(32);
        session.setAttribute("state", state);
        log.debug(state);


        JSONObject config = gService.getConfig();
        config.put("state", state);
        return config.toString();
    }
}

