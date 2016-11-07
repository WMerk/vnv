package com.vnv.Controller;

import com.vnv.Entity.User;
import com.vnv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

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

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void insertUser(@RequestParam User user){
        userService.insertUser(user);
    }
}
