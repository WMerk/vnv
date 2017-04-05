package com.vnv.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private static Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }

}
