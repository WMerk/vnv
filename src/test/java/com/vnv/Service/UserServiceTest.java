package com.vnv.Service;

import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import com.vnv.Fake;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.vnv.Fake.faker;
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

    User testUser = Fake.getFakeUser();
    String mail = testUser.getMail();
    String pw = testUser.getHashedPw();
    String sessionId = testUser.getSessionId();

    @Test
    public void registerUser() throws Exception {


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
    public void changePassword() throws Exception {
        loginUserCorrect();
        String newPassword = faker.internet().password();
        long uid = user.getLong("uid");
        //providing wrong password
        user = us.changePassword(uid, "wrongPassword", newPassword, sessionId);
        assertNotNull(user);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongPassword, user.toString());

        //providing correct password
        user = us.changePassword(uid, pw, newPassword, sessionId);
        assertNotNull(user);
        assertFalse(user.has("error"));

        //login with old password
        JSONObject res = us.loginUser(mail, pw, sessionId);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.WrongMailPassword, res.toString());

        //login with new password
        res = us.loginUser(mail, newPassword, sessionId);
        assertFalse(res.has("error"));

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