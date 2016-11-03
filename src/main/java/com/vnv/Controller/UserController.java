package com.vnv.Controller;

import com.vnv.Entity.User;
import com.vnv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Waldemar on 03.11.2016.
 */
@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUser(){
        return userService.getAllUser();
    }
}
