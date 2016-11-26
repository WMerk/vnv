package com.vnv.Controller;

import com.vnv.Entity.User;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String registerUser(@RequestBody User user, HttpSession session){
        //System.out.println(user);
        user.setSessionId(session.getId());
        JSONObject res = userService.registerUser(user);
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String loginUser(@RequestBody User user, HttpSession session){
        JSONObject res = userService.loginUser(user.getMail(), user.getHashedPw(), session.getId());
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String logoutUser(@RequestBody User user, HttpSession session){
        JSONObject res = userService.logoutUser(session.getId());
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String deleteUser(@RequestBody User user, HttpSession session) {
        JSONObject res = userService.deleteUser(session.getId(), user.getUid(), user.getHashedPw());
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String changePassword(@RequestBody User user, HttpSession session) {
        log.debug(user.toString());
        JSONObject res = userService.changePassword(user.getUid(),
                user.getPassword(), user.getNewPassword(), session.getId());
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String updateUser(@RequestBody User user, HttpSession session) {
        log.debug(user.toString());
        JSONObject res = userService.updateUser(user, session.getId());
        log.debug(res.toString());
        return res.toString();
    }

}
