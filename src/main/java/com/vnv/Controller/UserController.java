package com.vnv.Controller;

import com.vnv.Entity.User;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("..webapp/main")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeUserById(@PathVariable("id") int id){
        userService.removeUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }


    @RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String registerUser(@RequestBody User user){
        //System.out.println(user);
        JSONObject res = userService.registerUser(user);
        log.debug(res.toString());
        return res.toString();
    }


}
