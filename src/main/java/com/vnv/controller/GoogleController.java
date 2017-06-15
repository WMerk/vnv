package com.vnv.controller;

import com.vnv.entity.GoogleCode;
import com.vnv.service.GoogleService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
public class GoogleController {

    private static Logger log = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    GoogleService gService;


    @RequestMapping(value="/auth/google", method= RequestMethod.POST)
    public ResponseEntity gconnect(@RequestBody GoogleCode googleCode, HttpSession session) {
        log.debug(googleCode.toString());
        JSONObject json = gService.login(googleCode.getCode(), googleCode.getState(), googleCode.getRedirectUri(), session);
        log.debug(json.toString());
        int status = 200;
        if (json.has("status")) {
            status = json.getInt("status");
        }
        return ResponseEntity.status(status).body(json.toString());
    }

    @RequestMapping("/gconfig")
    public ResponseEntity getGoogleConfig(HttpSession session) {
        String state = new BigInteger(130, new SecureRandom()).toString(32);
        session.setAttribute("state", state);
        log.debug(state);


        JSONObject config = gService.getConfig();
        config.put("state", state);
        int status = 200;
        if (config.has("status")) {
            status = config.getInt("status");
        }
        return ResponseEntity.status(status).body(config.toString());
    }
}

