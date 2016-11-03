package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeUserDaoImp implements UserDao {

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

    @Override
    public Collection<User> getAllUser(){
        return this.users.values();
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public void removeUserById(int id) {
        this.users.remove(id);
    }

    @Override
    public void updateUser(User user){
        User u = users.get(user.getId());
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        users.put(user.getId(),user);
    }

    @Override
    public void insertUserToDb(User user) {
        this.users.put(user.getId(),user);
    }
}
