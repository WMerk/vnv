package com.vnv.Service;

import com.vnv.Controller.Password;
import com.vnv.Dao.RedisUserImpl;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import redis.clients.johm.JOhm;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;

@Service
public class UserService {

    @Autowired
    //@Qualifier("redis")
    @Qualifier("fakeData")
    private UserDao userDao;

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
        this.userDao.insertUserToDb(user);
    }

    public JSONObject registerUser(JSONObject json) {
        String pw, mail, fn, ln;
        try {
            //get required fields
            pw = json.getString("password");
            mail = json.getString("mail");
            fn = json.getString("firstName");
            ln = json.getString("lastName");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        User user = new User();
        String[] pwhash = Password.hashPassword(pw);
        user.setHashedPw(pwhash[0]);
        user.setSalt(pwhash[1]);
        user.setMail(mail);
        user.setMailValid(false);
        user.setFirstName(fn);
        user.setLastName(ln);

        //get optional fields
        if (json.has("phone")) {
            user.setPhone(json.getString("phone"));
            user.setPhoneValid(false);
        }
        if (json.has("googleId"))
            user.setGoogleId(json.getString("googleId"));
        if (json.has("facebookId"))
            user.setFacebookId(json.getString("facebookId"));

        System.out.println(user);
        userDao.insertUserToDb(user);

        return user.toJSON();
    }

}
