package com.vnv.Service;

import com.vnv.Dao.UserRelDao;
import com.vnv.Model.ErrorMessage;
import com.vnv.Model.Password;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    public Collection<User> getAllUser(){
        return this.userDao.getAllUser();
    }

    public User getUserById(int id){
        //A exists check should be implemented
        // and a errormessage on failor
        return this.userDao.getUserById(id);
    }

    public void removeUserById(int id) {
        this.userDao.removeUserById(id);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void insertUser(User user) {
        log.debug("Insert user {} to db", user);
        this.userDao.insertUserToDb(user);
    }

    public JSONObject registerUser(User user) {

        log.debug("Registering user {}", user);

        if (userDao.getUserByMail(user.getMail()) != null) {
            log.info("Mail {} already registered", user.getMail());
            return new JSONObject(ErrorMessage.AlreadyRegistered);
        }

        String[] pwhash = Password.hashPassword(user.getHashedPw());
        user.setHashedPw(pwhash[0]);
        user.setSalt(pwhash[1]);

        this.insertUser(user);
        user = userDao.getUserByMail(user.getMail());
        if (user==null) {
            return new JSONObject(String.format(ErrorMessage.Error, "could not register user"));
        }
        userRelDao.addUser(user);

        return user.toJSON();
    }

    public JSONObject loginUser(String mail, String pw, String sessionId) {
        User user = userDao.getUserByMail(mail);
        if (user==null) {
            //mail not found
            return new JSONObject(ErrorMessage.WrongMailPassword);
        }
        if (Password.checkPassword(pw, user.getSalt(), user.getHashedPw())) {
            user.setSessionId(sessionId);
            updateUser(user);
            return user.toJSON();
        }
        return new JSONObject(ErrorMessage.WrongMailPassword);
    }

    public boolean checkLogin(String sessionId, long uid) {
        User user = userDao.getUserBySessionId(sessionId);
        if (user!=null && user.getUid().longValue()==uid) {
            return true;
        }
        return false;
    }

    public JSONObject logoutUser(String sessionId) {
        User user = userDao.getUserBySessionId(sessionId);
        if (user==null) {
            return new JSONObject(ErrorMessage.AlreadyLoggedOut);
        }
        user.setSessionId(null);
        userDao.updateUser(user);
        return user.toJSON();
    }

    public JSONObject deleteUser(String sessionId, long uid) {
        if (checkLogin(sessionId, uid)) {
            userDao.removeUserById(uid);
            userRelDao.deleteUser(uid);
        }
        return new JSONObject(ErrorMessage.NotLoggedIn);
    }

}
