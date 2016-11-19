package com.vnv.Controller;

import com.vnv.Entity.Post;
import com.vnv.Service.PostService;
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
@RequestMapping("/posts")
public class PostController {

    private static Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(value="/insert", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String insertPost(@RequestBody Post post, HttpSession session) {
        JSONObject res =  postService.insertPost(post, session.getId());
        log.debug(res.toString());
        return res.toString();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String getCategories() {
        JSONObject res = postService.getCategories();
        log.debug(res.toString());
        return res.toString();
    }

}
