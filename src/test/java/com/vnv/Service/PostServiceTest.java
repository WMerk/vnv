package com.vnv.Service;

import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Main;
import org.json.JSONObject;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class PostServiceTest {

    @Autowired
    PostService ps;
    @Autowired
    UserService us;
    JSONObject res;
    long uid;
    long pid;

    @Before
    public void setUp() throws Exception {
        User u = new User();
        u.setSessionId("sessionId");
        u.setMail("a");
        u.setHashedPw("p");
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
        post.setDescription("This is a example post");

        res = ps.insertPost(post, "sessionId");
        assertNotNull(res);
        pid = res.getLong("id");
        System.out.println(res);
        assertFalse(res.has("error"));
    }

    @After
    public void tearDown() throws Exception {
        ps.deletePost("sessionId", uid, pid);
        us.deleteUser("sessionId", uid);
    }
}