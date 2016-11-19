package com.vnv.Service;

import com.vnv.Dao.PostDao;
import com.vnv.Entity.Post;
import com.vnv.Model.ErrorMessage;
import net.minidev.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class PostService {

    private static Logger log = LoggerFactory.getLogger(PostService.class);

    @Value("${app.posts.categories}")
    private String[] categories;

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserService userService;

    public JSONObject insertPost(Post post, String sessionId) {
        log.debug("Inserting post {} to database", post);
        if (userService.checkLogin(sessionId, post.getUid())) {
            if (categories != null && Arrays.asList(categories).contains(post.getCategory())) {
                return postDao.insertPost(post).toJSON();
            } else {
                return new JSONObject(ErrorMessage.NoCategory);
            }
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

    public JSONObject getCategories() {
        if (categories != null) {
            JSONArray jsonArray = new JSONArray();
            for (int i=0; i<categories.length; i++) {
                jsonArray.add(categories[i]);
            }
            return new JSONObject(String.format("{categories:%s}", jsonArray.toJSONString()));
        }
        return new JSONObject(ErrorMessage.NoCategoriesAvailable);
    }
}
