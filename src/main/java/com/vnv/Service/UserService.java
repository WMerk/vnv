package com.vnv.Service;

import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Waldemar on 03.11.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUser(){
        return userDao.getAllUser();
    }
}
