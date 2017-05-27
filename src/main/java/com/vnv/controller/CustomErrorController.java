package com.vnv.controller;

import com.vnv.model.ErrorJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    private boolean debug = false;

    @RequestMapping(value = "/error")
    public ErrorJSON error(HttpServletRequest request, HttpServletResponse response) {

        return new ErrorJSON(response.getStatus(), getErrorAttributes(request));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, debug);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @Profile("debug")
    @PostConstruct
    private void setDebug() {
        debug = true;
    }
}
