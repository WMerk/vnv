package com.vnv.Service;

import com.vnv.Dao.PostDao;
import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import com.vnv.Fake;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class PostServiceTest {

    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserRelDao userRelDao;
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
            JSONObject categories = res.getJSONObject(i);
            assertTrue(categories.has("id"));
            assertTrue(categories.has("name"));
        }
    }

    @After
    public void tearDown() throws Exception {
        postDao.deletePost(pid);
        userDao.removeUserById(uid);
        userRelDao.deleteUser(uid);
    }
}