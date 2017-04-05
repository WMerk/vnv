package com.vnv.Controller;

import com.vnv.Entity.GoogleCode;
import com.vnv.Service.GoogleService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
public class GoogleController {

    private static Logger log = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    GoogleService gService;
    

    @RequestMapping(value="/auth/google", method= RequestMethod.POST)
    String gconnect(@RequestBody GoogleCode googleCode, HttpSession session) {
        log.debug(googleCode.toString());
        JSONObject json = gService.login(googleCode.getCode(), googleCode.getState(), googleCode.getRedirect_uri(), session);
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

