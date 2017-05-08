package com.vnv.Service;

import com.vnv.Dao.CategoryDao;
import com.vnv.Dao.PostDao;
import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.Category;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Model.ErrorMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PostService {

    private static Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostDao postDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserRelDao userRelDao;

    @Autowired
    private UserDao userDao;

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

    public JSONObject getOwnPost(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = postDao.getPostsForUser(user);
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
        return json;
    }

    public JSONObject getOwnOffer(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = postDao.getOffersForUser(user);
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
        return json;
    }

    public JSONObject getOwnRequest(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = postDao.getRequestsForUser(user);
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
        return json;
    }

    public JSONObject getFriendPost(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = new ArrayList<>();
        Collection<User> friends = userRelDao.getFriends(user);
        for (User friend:friends) {
            posts.addAll(postDao.getPostsForUser(friend));
        }
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
        return json;
    }

    public JSONObject getFriendOffer(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = new ArrayList<>();
        Collection<User> friends = userRelDao.getFriends(user);
        for (User friend:friends) {
            posts.addAll(postDao.getOffersForUser(friend));
        }
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
        return json;
    }

    public JSONObject getFriendRequest(long uid, String sessionId) {
        if(!userService.checkLogin(sessionId, uid)) {
            return new JSONObject(ErrorMessage.NotLoggedIn);
        }
        User user = userDao.getUserById(uid);
        Collection<Post> posts = new ArrayList<>();
        Collection<User> friends = userRelDao.getFriends(user);
        for (User friend:friends) {
            posts.addAll(postDao.getRequestsForUser(friend));
        }
        JSONArray jsonArray = new JSONArray(posts);
        JSONObject json = new JSONObject();
        json.put("status", 200);
        json.put("data", jsonArray);
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
