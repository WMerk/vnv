package com.vnv.Service;

import com.github.javafaker.Faker;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

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

    Faker faker = new Faker(new Locale("de"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mail = firstName+"."+lastName+"@test.com";
    String pw = faker.lorem().word();
    String sessionId = faker.beer().style();

    @Test
    public void registerUser() throws Exception {

        User testUser = new User();
        testUser.setMail(mail);
        testUser.setFirstName(firstName);
        testUser.setLastName(lastName);
        testUser.setHashedPw(pw);
        testUser.setSessionId(sessionId);
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
        user = us.loginUser(mail, pw, sessionId);
        assertNotNull(user);
        assertFalse(user.has("error"));
    }

    @Test
    public void loginUserWrong() throws Exception {
        registerUser();
        JSONObject user = us.loginUser(mail, "wrongPassword", sessionId);
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongMailPassword, user.toString());
    }

    @Test
    public void loginUserNotExisting() throws Exception {
        JSONObject user = us.loginUser(mail, pw, sessionId);
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongMailPassword, user.toString());
    }

    @Test
    public void checkLogin() throws Exception {
        loginUserCorrect();
        assertTrue(us.checkLogin(sessionId, this.user.getLong("uid")));
        assertFalse(us.checkLogin("wrongSession", this.user.getLong("uid")));
    }

    @Test
    public void logout() throws Exception {
        user = us.logoutUser("noSessionId");
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.AlreadyLoggedOut, user.toString());

        loginUserCorrect();
        JSONObject user = us.logoutUser(sessionId);
        assertFalse(user.has("error"));
        assertFalse(us.checkLogin(sessionId, this.user.getLong("uid")));

        user = us.logoutUser(sessionId);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.AlreadyLoggedOut, user.toString());
    }

    @Test public void deleteUser() throws Exception {
        registerUser();
        JSONObject user = us.deleteUser(sessionId, this.user.getLong("uid"));
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