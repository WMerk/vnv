package com.vnv.Service;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Model.Fake;
import com.vnv.Main;
import com.vnv.Model.ErrorMessage;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.vnv.Model.Fake.faker;
import static org.junit.Assert.*;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class UserServiceTest {

    @Autowired
    UserService us;
    JSONObject user;

    @Autowired
    UserDao usDao;
    @Autowired
    UserRelDao usRelDao;

    User testUser = Fake.getFakeUser();
    String mail = testUser.getMail();
    String pw = testUser.getPassword();
    String sessionId = testUser.getSessionId();

    long friendUid;

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

        JSONObject user = us.deleteUser("wrongSession", this.user.getLong("uid"), pw);
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, user.toString());

        user = us.deleteUser(sessionId, this.user.getLong("uid"), "wrongPassword");
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.WrongPassword, user.toString());

        user = us.deleteUser(sessionId, this.user.getLong("uid"), pw);
        assertFalse(user.has("error"));
        assertNull(usDao.getUserById(this.user.getLong("uid")));

    }

    @Test public void updateUser() throws Exception {
        registerUser();

        User newUser = Fake.getFakeUser();
        newUser.setUid(this.user.getLong("uid"));

        JSONObject user = us.updateUser(newUser, "wrongSession");
        assertTrue(user.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, user.toString());

        user = us.updateUser(newUser, sessionId);
        assertFalse(user.has("error"));
        JSONAssert.assertEquals(newUser.toJSON(), user, false);
        JSONAssert.assertNotEquals(this.user, user, false);

    }

    @Test
    public void getUsers() throws Exception {
        registerUser();

        JSONObject res = us.getAllUser(testUser.getUid(), sessionId);
        System.out.println(res);
    }

    @Test
    public void getFriends() throws Exception {
        //System.out.println(usRelDao.getFriends(usDao.getUserById(2)));
        //TODO
    }

    @Test
    public void getNonRelatedUsers() throws Exception {
       // System.out.println(usRelDao.getNonRelatedUsers(usDao.getUserById(2)));
        //TODO
    }

    @Test
    public void sendFriendRequest() throws Exception {
        registerUser();

        User user = usDao.getUserById(this.user.getLong("uid"));
        User friend = usDao.insertUserToDb(Fake.getFakeUser());
        usRelDao.addUser(friend);
        friendUid = friend.getUid();

        JSONObject res = us.sendRequest("wrongSessionId", user, friend);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        res = us.sendRequest(sessionId, user, friend);
        assertFalse(res.has("error"));
        assertTrue(res.has("data"));
        assertTrue(res.has("request"));
        assertEquals("sent", res.getString("request"));
        JSONAssert.assertEquals(friend.toJSON(), res.getJSONObject("data"), false);
    }

    @Test
    public void acceptFriendRequest() throws Exception {
        sendFriendRequest();
        User userSentRequest = usDao.getUserById(user.getLong("uid"));
        User userReceivedRequest = usDao.getUserById(friendUid);

        //Wrong session id
        JSONObject res = us.acceptRequest("wrongSessionId", userReceivedRequest, userSentRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        //wrong direction
        res = us.acceptRequest(userSentRequest.getSessionId(), userSentRequest, userReceivedRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NoFriendRequestReceived, res.toString());

        res = us.acceptRequest(userReceivedRequest.getSessionId(), userReceivedRequest, userSentRequest);
        assertFalse(res.has("error"));
        assertTrue(res.has("data"));
        assertTrue(res.has("request"));
        assertEquals("accepted", res.getString("request"));
        JSONAssert.assertEquals(userSentRequest.toJSON(), res.getJSONObject("data"), false);
    }

    @Test
    public void declineFriendRequest() throws Exception {
        sendFriendRequest();
        User userSentRequest = usDao.getUserById(user.getLong("uid"));
        User userReceivedRequest = usDao.getUserById(friendUid);

        //Wrong session id
        JSONObject res = us.declineRequest("wrongSessionId", userReceivedRequest, userSentRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        //wrong direction
        res = us.declineRequest(userSentRequest.getSessionId(), userSentRequest, userReceivedRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NoFriendRequestReceived, res.toString());

        res = us.declineRequest(userReceivedRequest.getSessionId(), userReceivedRequest, userSentRequest);
        assertFalse(res.has("error"));
        assertTrue(res.has("data"));
        assertTrue(res.has("request"));
        assertEquals("declined", res.getString("request"));
        JSONAssert.assertEquals(userSentRequest.toJSON(), res.getJSONObject("data"), false);
    }

    @Test
    public void deleteFriendRequest() throws Exception {
        sendFriendRequest();
        User userSentRequest = usDao.getUserById(user.getLong("uid"));
        User userReceivedRequest = usDao.getUserById(friendUid);

        //Wrong session id
        JSONObject res = us.deleteRequest("wrongSessionId", userSentRequest, userReceivedRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NotLoggedIn, res.toString());

        //wrong direction
        res = us.deleteRequest(userReceivedRequest.getSessionId(), userReceivedRequest, userSentRequest);
        assertTrue(res.has("error"));
        assertEquals(ErrorMessage.NoFriendRequestSent, res.toString());

        res = us.deleteRequest(userSentRequest.getSessionId(), userSentRequest, userReceivedRequest);
        assertFalse(res.has("error"));
        assertTrue(res.has("data"));
        assertTrue(res.has("request"));
        assertEquals("deleted", res.getString("request"));
        JSONAssert.assertEquals(userReceivedRequest.toJSON(), res.getJSONObject("data"), false);
    }

    //TODO delete friendship

    @After
    public void tearDown() {
        if (user != null) {
            System.out.println("DELETE USER " + user.getLong("uid"));
            usDao.removeUserById(user.getLong("uid"));
            usRelDao.deleteUser(user.getLong("uid"));
        }
        if(friendUid!=0) {
            System.out.println("DELETE USER "+friendUid);
            usDao.removeUserById(friendUid);
            usRelDao.deleteUser(friendUid);
        }
    }


}