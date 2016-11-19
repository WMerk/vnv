package com.vnv.Service;

import com.github.javafaker.Faker;
import com.vnv.Dao.PostDao;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import com.vnv.Model.Fake;
import cucumber.api.java.cs.A;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.johm.JOhm;

import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class PostServiceTest {

    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PostService ps;
    @Autowired
    UserService us;
    JSONObject res;
    long uid;
    long pid;

    User u = Fake.getFakeUser();
    String sessionId = u.getSessionId();

    @Before
    public void setUp() throws Exception {
        uid = us.registerUser(u).getLong("uid");
    }

    @Test
    public void createPost() throws Exception {
        Post post = Fake.getFakeOffer(uid);

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
    public void deletePostTest() throws Exception {
        createPost();
        JSONObject user = ps.deletePost(sessionId, uid, pid);
        assertFalse(user.has("error"));
        assertNull(postDao.getPostById(pid));

        user = ps.deletePost("wrongSession", uid, pid);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, user.toString());
    }

    @After
    public void tearDown() throws Exception {
        postDao.deletePost(pid);
        userDao.removeUserById(uid);
    }
}