package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Waldemar on 03.11.2016.
 */
@Repository
public class UserDao {

    public static Map<Integer,User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1,new User(1,"Patrick","patrick@gmail.com"));
                put(2,new User(2,"Gabriel","gabriel@gmail.com"));
                put(3,new User(3,"Waldemar","merk@gmail.com"));
            }
        };
    }

    public Collection<User> getAllUser(){
        return this.users.values();
    }

    public User getUserById(int id) {
        return users.get(id);
    }
}
