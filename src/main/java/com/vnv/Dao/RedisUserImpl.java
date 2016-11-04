package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import redis.clients.johm.JOhm;

import java.util.Collection;

@Repository
@Qualifier("redis")
public class RedisUserImpl implements UserDao{


    @Override
    public Collection<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return JOhm.get(User.class, id);
    }

    @Override
    public void removeUserById(int id) {
        JOhm.delete(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        JOhm.save(user);
    }

    @Override
    public void insertUserToDb(User user) {
        JOhm.save(user);
    }
}
