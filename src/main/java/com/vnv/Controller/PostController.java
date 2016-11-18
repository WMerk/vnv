package com.vnv.Controller;

import com.vnv.Entity.Post;
import com.vnv.Model.ErrorMessage;
import com.vnv.Service.PostService;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("post")
public class PostController {

    private static Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="", method= RequestMethod.POST)
    public String insertPost(@RequestBody Post post, HttpSession session) {
        JSONObject res =  postService.insertPost(post, session.getId());
        log.debug(res.toString());
        return res.toString();
    }
}
