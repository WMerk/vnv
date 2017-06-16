package com.vnv.service;

import com.vnv.Main;
import com.vnv.dao.CategoryDao;
import com.vnv.dao.PostDao;
import com.vnv.dao.UserDao;
import com.vnv.dao.UserRelDao;
import com.vnv.entity.Category;
import com.vnv.entity.Post;
import com.vnv.entity.User;
import com.vnv.model.ErrorMessage;
import com.vnv.model.Fake;
import com.vnv.model.Profiles;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class PostServiceTest {

    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserRelDao userRelDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    PostService ps;
    @Autowired
    UserService us;
    JSONObject res;
    long uid;
    long pid;

    User u = Fake.getFakeUser();
    String sessionId = u.getSessionId();

    @Value("${app.posts.categories}")
    private String[] categories;

    @Before
    public void setUp() throws Exception {
        uid = us.registerUser(u).getLong("uid");
    }

    @Test
    public void createPost() throws Exception {
        if (Profiles.checkDebugActive())
            ps.initCategories();
        Post post = Fake.getFakeOffer(userDao.getUserById(uid));

        res = ps.insertPost(post, "wrongSessionId");
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        res = ps.insertPost(post, sessionId);
        assertNotNull(res);
        System.out.println(res);
        assertFalse(res.has("error"));
        pid = res.getLong("id");
    }

    @Test
    public void updatePostTest() throws Exception {
        createPost();
        Post updated = postDao.getPostById(pid);
        updated.setStatus("other");
        updated.setDescription("new description");
        JSONObject res = ps.updatePost(updated, "wrongSession");
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        res = ps.updatePost(updated, sessionId);
        assertFalse(res.has("error"));
        JSONAssert.assertEquals(updated.toJSON(), res, false);

        updated = Fake.getFakeOffer(userDao.getUserById(uid));
        updated.setId(pid);
        res = ps.updatePost(updated, sessionId);
        assertFalse(res.has("error"));
        JSONAssert.assertEquals(updated.toJSON(), res, false);

    }

    @Test
    public void deletePostTest() throws Exception {
        createPost();
        JSONObject user = ps.deletePost(sessionId, uid, pid);
        assertFalse(user.has("error"));
        assertNull(postDao.getPostById(pid));

        user = ps.deletePost("wrongSession", uid, pid);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, user.toString());
    }

    @Test
    public void categories() throws Exception {
        //setup
        ps.initCategories();

        JSONArray res = ps.getCategories();
        assertNotNull(res);
        assertFalse(res.length()==0);
        for (int i=0; i<this.categories.length; i++) {
            Category c = categoryDao.getCategoryByName(this.categories[i]);
            assertNotNull(c);
        }
    }

    @After
    public void tearDown() throws Exception {
        postDao.deletePost(pid);
        userDao.removeUserById(uid);
        userRelDao.deleteUser(uid);
    }
}