package com.vnv.service;

import com.vnv.dao.CategoryDao;
import com.vnv.dao.PostDao;
import com.vnv.dao.UserDao;
import com.vnv.dao.UserRelDao;
import com.vnv.entity.Category;
import com.vnv.entity.Post;
import com.vnv.entity.User;
import com.vnv.model.ErrorMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        post.setStatus("Verfügbar");
        log.debug("Inserting post {} to database", post);
        if (userService.checkLogin(sessionId, post.getUser().getUid())) {
                return postDao.insertPost(post).toJSON();
        }
        log.debug("Aborting, user not logged in");
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    private Post combinePosts(Post storedPost, Post updatedPost) throws InvocationTargetException, IllegalAccessException {
        log.debug(storedPost.toString());
        log.debug(updatedPost.toString());
        for (Method method : updatedPost.getClass().getMethods()) {
            Class returnType = method.getReturnType();
            String methodName = method.getName();
            if (!returnType.equals(void.class) && methodName.startsWith("get")) {
                //System.out.println(method.getName());
                Object response = method.invoke(updatedPost);
                if (response!= null) {
                    try {
                        Method setMethod = storedPost.getClass().getMethod(methodName.replace("get", "set"), returnType);
                        setMethod.invoke(storedPost, response);
                    } catch (NoSuchMethodException e) {
                        //should only happen for getClass which is ok
                        log.warn(e.getMessage());
                    }
                }
            }
        }
        log.debug(storedPost.toString());
        return storedPost;
    }

    public JSONObject updatePost(Post post, String sessionId) {
        if (post.getUser().getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (userService.checkLogin(sessionId, post.getUser().getUid())) {
            log.debug("updating post {}", post);
            Post storedPost = postDao.getPostById(post.getId());
            try {
                post = combinePosts(storedPost, post);
            } catch (InvocationTargetException | IllegalAccessException e) {
                log.error(e.getLocalizedMessage());
                return new JSONObject(ErrorMessage.DefaultError);
            }
            return postDao.updatePost(post).toJSON();
        }
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
        if (friends!=null) for (User friend:friends) {
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
