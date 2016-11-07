package com.vnv.Service;

import com.vnv.Controller.Password;
import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    public JSONObject registerUser(User user) {

        String[] pwhash = Password.hashPassword(user.getHashedPw());
        user.setHashedPw(pwhash[0]);
        user.setSalt(pwhash[1]);

        this.insertUser(user);

        return user.toJSON();
    }

}
