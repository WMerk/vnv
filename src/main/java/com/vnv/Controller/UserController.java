package com.vnv.Controller;

import com.vnv.Entity.User;
import com.vnv.Model.Fake;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registerUser(@RequestBody User user, HttpSession session){
        JSONObject res = userService.registerUser(user);
        log.debug(res.toString());
        userService.loginUser(user.getMail(), user.getPassword(), session.getId());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity loginUser(@RequestBody User user, HttpSession session){
        JSONObject res = userService.loginUser(user.getMail(), user.getPassword(), session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity logoutUser(@RequestBody User user, HttpSession session){
        JSONObject res = userService.logoutUser(session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteUser(@RequestBody User user, HttpSession session) {
        JSONObject res = userService.deleteUser(session.getId(), user.getUid(), user.getPassword());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity changePassword(@RequestBody User user, HttpSession session) {
        log.debug(user.toString());
        JSONObject res = userService.changePassword(user.getUid(),
                user.getPassword(), user.getNewPassword(), session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateUser(@RequestBody User user, HttpSession session) {
        log.debug(user.toString());
        JSONObject res = userService.updateUser(user, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllUsers(@RequestParam long uid, HttpSession session) {
        JSONObject res = userService.getAllUser(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @Profile("debug")
    @RequestMapping(value = "/fake", method = RequestMethod.POST)
    public String addFakeUsers(@RequestParam int number) {
        Fake f = new Fake();
        f.makeFakeDbEntries(number);
        return "ok";
    }

    @RequestMapping(value = "/friend/request", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity sentFriendRequest(@RequestBody Map<String, User> map, HttpSession session) {
        User user = map.get("user");
        User friend = map.get("friend");
        if (user==null || friend==null)
            throw new HttpMessageNotReadableException("Could not read document: Can not construct instance of com.vnv.Entity.User");
        log.debug(user.toString());
        log.debug(friend.toString());
        JSONObject res = userService.sentRequest(session.getId(), user, friend);
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

}
