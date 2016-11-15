package com.vnv.Service;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.*;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class UserServiceTest {

    @Autowired
    UserService us;
    JSONObject user;

    @Autowired
    UserDao usDao;

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
        JSONObject user = us.registerUser(testUser);
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.AlreadyRegistered, user.toString());

    }

    @Test
    public void loginUserCorrect() throws Exception {
        registerUser();
        System.out.println(user);
        user = us.loginUser("test.user@test.com", "notHashed", "sessionId");
        assertNotNull(user);
        assertFalse(user.has("error"));
    }

    @Test
    public void loginUserWrong() throws Exception {
        registerUser();
        JSONObject user = us.loginUser("test.user@test.com", "wrongPassword", "sessionId");
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongMailPassword, user.toString());
    }

    @Test
    public void loginUserNotExisting() throws Exception {
        JSONObject user = us.loginUser("test.user@test.com", "notHashed", "sessionId");
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongMailPassword, user.toString());
    }

    @Test
    public void checkLogin() throws Exception {
        loginUserCorrect();
        assertTrue(us.checkLogin("sessionId", this.user.getLong("uid")));
        assertFalse(us.checkLogin("session", this.user.getLong("uid")));
    }

    @Test
    public void logout() throws Exception {
        user = us.logoutUser("noSessionId");
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.AlreadyLoggedOut, user.toString());

        loginUserCorrect();
        JSONObject user = us.logoutUser("sessionId");
        assertFalse(user.has("error"));
        assertFalse(us.checkLogin("sessionId", this.user.getLong("uid")));

        user = us.logoutUser("sessionId");
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.AlreadyLoggedOut, user.toString());
    }

    @Test public void deleteUser() throws Exception {
        registerUser();
        JSONObject user = us.deleteUser("session", this.user.getLong("uid"));
        assertFalse(user.has("error"));
        assertNull(usDao.getUserById(this.user.getLong("uid")));

        user = us.deleteUser("wrongSession", this.user.getLong("uid"));
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, user.toString());

    }

    @After
    public void tearDown() {
        if (user != null) {
            System.out.println("DELETE USER " + user.getLong("uid"));
            usDao.removeUserById(user.getLong("uid"));
        }
    }


}