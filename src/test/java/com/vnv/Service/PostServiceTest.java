package com.vnv.Service;

import com.github.javafaker.Faker;
import com.vnv.Dao.PostDao;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import cucumber.api.java.cs.A;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    Faker faker = new Faker(new Locale("de"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mail = firstName+"."+lastName+"@test.com";
    String pw = faker.lorem().word();
    String sessionId = faker.beer().name();

    @Before
    public void setUp() throws Exception {
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setSessionId(sessionId);
        u.setMail(mail);
        u.setHashedPw(pw);
        uid = us.registerUser(u).getLong("uid");
    }

    @Test
    public void createPost() throws Exception {
        Post post = new Post();
        post.setPostName("Test");
        post.setType("offer");
        post.setFlavour("verschenken");
        post.setCategory("Technik");
        post.setUid(uid);
        post.setDescription(faker.lorem().sentence());

        res = ps.insertPost(post, sessionId);
        assertNotNull(res);
        pid = res.getLong("id");
        System.out.println(res);
        assertFalse(res.has("error"));
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