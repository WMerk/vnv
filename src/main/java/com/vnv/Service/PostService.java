package com.vnv.Service;

import com.vnv.Dao.CategoryDao;
import com.vnv.Dao.PostDao;
import com.vnv.Entity.Category;
import com.vnv.Entity.Post;
import com.vnv.Model.ErrorMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    private static Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostDao postDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserService userService;

    public JSONObject insertPost(Post post, String sessionId) {
        log.debug("Inserting post {} to database", post);
        if (userService.checkLogin(sessionId, post.getUser().getUid())) {
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

    public JSONArray getCategories() {
        Collection<Category> categories = categoryDao.getAllCategories();
        JSONArray /*json = new JSONArray(Arrays.asList(categories));*/
        json = new JSONArray(categories);
        return json;
    }

    @Value("${app.posts.categories}")
    private String[] categories;

    //@PostConstruct
    public void initCategories() {
        if (categories!=null) {
            for (String c : categories) {
                if (c != null && categoryDao.getCategoryByName(c)==null) {
                    Category category = new Category();
                    category.setName(c);
                    log.debug(categoryDao.insertCategory(category).toString());
                }
            }
        }
    }
}
