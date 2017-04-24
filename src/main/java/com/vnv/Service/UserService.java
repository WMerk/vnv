package com.vnv.Service;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Model.ErrorMessage;
import com.vnv.Model.Password;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

@Service
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);


    @Autowired
    //@Qualifier("redis")
    //@Qualifier("fakeData")
    private UserDao userDao;

    @Autowired
    //@Qualifier("neo4j")
    //@Qualifier("fakeData")
    private UserRelDao userRelDao;

    public JSONObject getReceivedFriendRequest(long uid, String sessionId) {
        log.debug("Getting Received friend requests");

        if (userDao.getUserBySessionId(sessionId)==null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (!checkLogin(sessionId, uid))
            return new JSONObject(ErrorMessage.NotLoggedIn);

        User user = userDao.getUserById(uid);
        Collection<User> requestsRec = userRelDao.getRequestsRecv(user);
        JSONArray jsonArray = new JSONArray();
        if (requestsRec!=null) {
            for (User u : requestsRec) {
                jsonArray.put(u.toJSON());
            }
        }
        // Have to do is in the above ay and can't use the following, because the toJSON methode has to be called to hide certain fields
        // JSONArray jsonArray = new JSONArray(requestsRec);
        JSONObject json = new JSONObject();
        json.put("data", jsonArray);
        json.put("user", user.toJSON());
        json.put("status", 200);
        return json;
    }

    public JSONObject getSentFriendRequest(long uid, String sessionId) {
        log.debug("Getting Sent friend requests");

        if (userDao.getUserBySessionId(sessionId)==null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (!checkLogin(sessionId, uid))
            return new JSONObject(ErrorMessage.NotLoggedIn);

        User user = userDao.getUserById(uid);
        Collection<User> requestsSent = userRelDao.getRequestsSent(user);
        JSONArray jsonArray = new JSONArray();
        if (requestsSent!=null) {
            for (User u : requestsSent) {
                jsonArray.put(u.toJSON());
            }
        }
        // Have to do is in the above ay and can't use the following, because the toJSON methode has to be called to hide certain fields
        // JSONArray jsonArray = new JSONArray(requestsSent);
        JSONObject json = new JSONObject();
        json.put("data", jsonArray);
        json.put("user", user.toJSON());
        json.put("status", 200);
        return json;
    }

    public JSONObject getFriends(long uid, String sessionId) {
        log.debug("Getting friends");

        if (userDao.getUserBySessionId(sessionId)==null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (!checkLogin(sessionId, uid))
            return new JSONObject(ErrorMessage.NotLoggedIn);

        User user = userDao.getUserById(uid);
        Collection<User> friends = userRelDao.getFriends(user);
        JSONArray jsonArray = new JSONArray();
        if (friends!=null) {
            for (User u : friends) {
                jsonArray.put(u.toJSON());
            }
        }
        // Have to do is in the above ay and can't use the following, because the toJSON methode has to be called to hide certain fields
        // JSONArray jsonArray = new JSONArray(friends);
        JSONObject json = new JSONObject();
        json.put("data", jsonArray);
        json.put("user", user.toJSON());
        json.put("status", 200);
        return json;
    }

    public JSONObject getAllUser(long uid, String sessionId){
        log.debug("getting all users");

        if (userDao.getUserBySessionId(sessionId)==null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (!checkLogin(sessionId, uid))
            return new JSONObject(ErrorMessage.NotLoggedIn);

        User user = userDao.getUserById(uid);
        Collection<User> friendsC = userRelDao.getFriends(user);
        Collection<User> requestsRecC = userRelDao.getRequestsRecv(user);
        Collection<User> requestsSentC = userRelDao.getRequestsSent(user);
        Collection<User> rest = userRelDao.getNonRelatedUsers(user);

        JSONArray array = new JSONArray();
        if (friendsC!=null)
            for (User u:friendsC) {
                //System.out.println(u);
                JSONObject data = u.toJSON();
                JSONObject json = new JSONObject();
                json.put("data", data);
                json.put("request", "accepted");
                array.put(json);
            }
        if (requestsSentC!=null)
            for (User u:requestsSentC) {
                //System.out.println(u);
                JSONObject data = u.toJSON();
                JSONObject json = new JSONObject();
                json.put("data", data);
                json.put("request", "sent");
                array.put(json);
            }
        if (requestsRecC!=null)
            for (User u:requestsRecC) {
                //System.out.println(u);
                JSONObject data = u.toJSON();
                JSONObject json = new JSONObject();
                json.put("data", data);
                json.put("request", "received");
                array.put(json);
            }
        if(rest!=null)
            for (User u:rest) {
                if (u.getUid()!= uid) {
                    //System.out.println(u);
                    JSONObject data = u.toJSON();
                    JSONObject json = new JSONObject();
                    json.put("data", data);
                    json.put("request", "none");
                    array.put(json);
                }
            }
        return new JSONObject().put("users", array);
    }

    private User getUserById(long id){
        //A exists check should be implemented
        // and a errormessage on failor
        log.debug("getting user by id {}", id);
        return this.userDao.getUserById(id);
    }

    private User combineUsers(User storedUser, User updatedUser) throws InvocationTargetException, IllegalAccessException {
        log.debug(storedUser.toString());
        log.debug(updatedUser.toString());
        for (Method method : updatedUser.getClass().getMethods()) {
            Class returnType = method.getReturnType();
            String methodName = method.getName();
            if (!returnType.equals(void.class) && methodName.startsWith("get")) {
                //System.out.println(method.getName());
                Object response = method.invoke(updatedUser);
                if (response!= null) {
                    try {
                        Method setMethod = storedUser.getClass().getMethod(methodName.replace("get", "set"), returnType);
                        setMethod.invoke(storedUser, response);
                    } catch (NoSuchMethodException e) {
                        //should only happen for getClass which is ok
                        log.warn(e.getMessage());
                    }
                }
            }
        }
        log.debug(storedUser.toString());
        return storedUser;
    }

    public JSONObject updateUser(User user, String sessionId) {
        if (user.getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (checkLogin(sessionId, user.getUid())) {
            log.debug("updating user {}", user);
            user.setHashedPw(null); // explicit setting hashedPw to null to prevent changing this field
            user.setSalt(null);     // ^^
            User storedUser = userDao.getUserById(user.getUid());
            try {
                user = combineUsers(storedUser, user);
            } catch (InvocationTargetException | IllegalAccessException e) {
                log.error(e.getLocalizedMessage());
                return new JSONObject(ErrorMessage.DefaultError);
            }
            userRelDao.updateUser(user, user.getUid());
            return userDao.updateUser(user).toJSON();
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    private void insertUser(User user) {
        log.debug("Insert user {} to db", user);
        this.userDao.insertUserToDb(user);
    }

    public JSONObject registerUser(User user) {
        log.debug("Registering user {}", user);
        if (userDao.getUserByMail(user.getMail()) != null) {
            log.info("Mail {} already registered", user.getMail());
            return new JSONObject(ErrorMessage.AlreadyRegistered);
        }

        String[] pwhash = Password.hashPassword(user.getPassword());
        user.setHashedPw(pwhash[0]);
        user.setSalt(pwhash[1]);

        this.insertUser(user);
        user = userDao.getUserByMail(user.getMail());
        if (user==null) {
            return new JSONObject(String.format(ErrorMessage.getError("could not register user", 404)));
        }
        log.debug("User {} successfully added to DB", user);
        log.debug("Adding user to graphDB");
        userRelDao.addUser(user);

        return user.toJSON();
    }

    public JSONObject changePassword(long uid, String oldPassword, String newPassword, String sesionId) {
        if (checkLogin(sesionId, uid)) {
            User user = userDao.getUserById(uid);
            if (Password.checkPassword(oldPassword, user.getSalt(), user.getHashedPw())) {
                String[] pwH = Password.hashPassword(newPassword);
                user.setHashedPw(pwH[0]);
                user.setSalt(pwH[1]);
                user = userDao.updateUser(user);
                if (user == null)
                    return new JSONObject(ErrorMessage.DefaultError);
                return user.toJSON();
            } else {
                log.debug("Wrong password");
                return new JSONObject(ErrorMessage.WrongPassword);
            }
        }
        log.debug("Aborting user not logged in");
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject loginUser(String mail, String pw, String sessionId) {
        log.debug("Log in for user with mail {}", mail);
        User user = userDao.getUserByMail(mail);
        if (user==null) {
            //mail not found
            return new JSONObject(ErrorMessage.WrongMailPassword);
        }
        if (Password.checkPassword(pw, user.getSalt(), user.getHashedPw())) {
            User sameSessionId = userDao.getUserBySessionId(sessionId);
            if (sameSessionId!=null) {
                logoutUser(sessionId);
            }
            user.setSessionId(sessionId);
            userDao.updateUser(user);
            return user.toJSON();
        }
        return new JSONObject(ErrorMessage.WrongMailPassword);
    }

    public boolean checkLogin(String sessionId, long uid) {
        log.debug("Checking if user with uid {} and sessionId {} is logged in", uid, sessionId);
        User user = userDao.getUserBySessionId(sessionId);
        if (user!=null && user.getUid().longValue()==uid) {
            return true;
        }
        return false;
    }

    public JSONObject logoutUser(String sessionId) {
        log.debug("Log out for sessionId {}", sessionId);
        User user = userDao.getUserBySessionId(sessionId);
        if (user==null) {
            return new JSONObject(ErrorMessage.AlreadyLoggedOut);
        }
        user.setSessionId(null);
        userDao.updateUser(user);
        return user.toJSON();
    }

    public JSONObject deleteUser(String sessionId, long uid, String pw) {
        log.debug("Deleting user with uid {} and sessionId {}", uid, sessionId);
        if (checkLogin(sessionId, uid)) {
            User storedUser = userDao.getUserById(uid);
            if (Password.checkPassword(pw, storedUser.getSalt(), storedUser.getHashedPw())) {
                userDao.removeUserById(uid);    //deletes the user from the database
                userRelDao.deleteUser(uid);     //deletes the user from the graph database
                //this includes deleting all friend connections and friend requests
                //TODO                          //all posts for that user has to be deleted or at least updated to an explaining status
                // ...
                return new JSONObject("{\"ok\":\"200\"}");
            }
            return new JSONObject(ErrorMessage.WrongPassword);
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject sendRequest(String sessionId, User user, User friend) {
        log.debug("Saving request from user {} to {}.", user, friend);
        if (user.getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (checkLogin(sessionId, user.getUid())) {
            userRelDao.addRequest(user, friend);
            JSONObject jsonFriend = userDao.getUserById(friend.getUid()).toJSON();
            JSONObject res = new JSONObject();
            res.put("data", jsonFriend);
            res.put("request", "sent");
            return res;
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject acceptRequest(String sessionId, User user, User friend) {
        log.debug("Accepting request from user {} to {}.", friend, user);
        if (user.getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (checkLogin(sessionId, user.getUid())) {
                            Collection received = userRelDao.getRequestsRecv(user);
            if (received==null||!received.contains(friend)) {
                return new JSONObject(ErrorMessage.NoFriendRequestReceived);
            }
            userRelDao.addFriend(user, friend);
            userRelDao.removeRequest(friend, user);
            JSONObject jsonFriend = userDao.getUserById(friend.getUid()).toJSON();
            JSONObject res = new JSONObject();
            res.put("data", jsonFriend);
            res.put("request", "accepted");
            return res;
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject declineRequest(String sessionId, User user, User friend) {
        log.debug("Decline request from user {} to {}.", friend, user);
        if (user.getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (checkLogin(sessionId, user.getUid())) {
            Collection received = userRelDao.getRequestsRecv(user);
            if (received==null||!received.contains(friend)) {
                return new JSONObject(ErrorMessage.NoFriendRequestReceived);
            }
            userRelDao.removeRequest(friend, user);
            JSONObject jsonFriend = userDao.getUserById(friend.getUid()).toJSON();
            JSONObject res = new JSONObject();
            res.put("data", jsonFriend);
            res.put("request", "declined");
            return res;
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

    public JSONObject deleteFriendship(String sessionId, User user, User friend) {
        log.debug("Delete friendship from user {} to {}.", friend, user);
        if (user.getUid() == null)
            return new JSONObject(ErrorMessage.NotLoggedIn);
        if (checkLogin(sessionId, user.getUid())) {
            Collection friends = userRelDao.getFriends(user);
            if (friends==null||!friends.contains(friend)) {
                return new JSONObject(ErrorMessage.NotFriendly);
            }
            userRelDao.removeFriend(user, friend);
            JSONObject jsonFriend = userDao.getUserById(friend.getUid()).toJSON();
            JSONObject res = new JSONObject();
            res.put("data", jsonFriend);
            res.put("request", "terminated");
            return res;
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }



}
