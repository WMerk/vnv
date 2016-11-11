package com.vnv.Service;

import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class UserServiceTest {

    @Autowired
    UserService us;
    JSONObject user;

    @Test
    public void registerUser() throws Exception {

        User testUser = new User();
        testUser.setMail("test.user@test.com");
        testUser.setFirstName("test");
        testUser.setLastName("user");
        testUser.setHashedPw("notHashed");
        testUser.setSessionId("session");
        user = us.registerUser(testUser);
        assertNotNull(user);
        assertFalse(user.has("error"));
    }

    @After
    public void tearDown() {
        us.deleteUser("session", user.getLong("uid"));
    }


}