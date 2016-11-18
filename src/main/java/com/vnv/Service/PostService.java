package com.vnv.Service;

import com.vnv.Dao.PostDao;
import com.vnv.Entity.Post;
import com.vnv.Model.ErrorMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private static Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostDao postDao;

    @Autowired
    UserService userService;

    public JSONObject insertPost(Post post, String sessionId) {
        log.debug("Inserting post {} to database", post);
        if (userService.checkLogin(sessionId, post.getUid())) {
            return postDao.insertPost(post).toJSON();
        }
        log.debug("Aborting, user not logged in");
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject deletePost(String sessionId, long uid, long postId) {
        log.debug("Deleting post from user {} with postId {}", uid, postId);
        if (userService.checkLogin(sessionId, uid)) {
            postDao.deletePost(postId);
            return new JSONObject("{\"ok\":\"200\"}");
        }
        log.debug("Aborting, user not logged in");
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }
}
