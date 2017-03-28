package com.vnv.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.SecureRandom;

@org.springframework.stereotype.Controller
public class Controller {

    private static Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect(HttpSession session) {
        String state = new BigInteger(130, new SecureRandom()).toString(32);
        session.setAttribute("state", state);
        log.debug(state);
        return "forward:/";
    }

}
