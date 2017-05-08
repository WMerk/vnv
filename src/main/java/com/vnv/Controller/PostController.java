package com.vnv.Controller;

import com.vnv.Entity.Post;
import com.vnv.Service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/posts")
public class PostController {

    private static Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value="/insert", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity insertPost(@RequestBody Post post, HttpSession session) {
        JSONObject res =  postService.insertPost(post, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deletePost(@RequestBody Post post, HttpSession session) {
        JSONObject res = postService.deletePost(session.getId(), post.getUser().getUid(), post.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String getCategories() {
        JSONArray res = postService.getCategories();
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value = "/own", method = RequestMethod.GET)
    public ResponseEntity getOwnPosts(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getOwnPost(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/own/offers", method = RequestMethod.GET)
    public ResponseEntity getOwnOffers(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getOwnOffer(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/own/requests", method = RequestMethod.GET)
    public ResponseEntity getOwnRequests(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getOwnRequest(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public ResponseEntity getFriendPosts(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getFriendPost(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/friends/offers", method = RequestMethod.GET)
    public ResponseEntity getFriendOffers(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getFriendOffer(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

    @RequestMapping(value = "/friends/requests", method = RequestMethod.GET)
    public ResponseEntity getFriendRequests(@RequestParam long uid, HttpSession session) {
        JSONObject res = postService.getFriendRequest(uid, session.getId());
        log.debug(res.toString());
        int status = 200;
        if (res.has("status")) {
            status = res.getInt("status");
        }
        return ResponseEntity.status(status).body(res.toString());
    }

}
