package com.vnv.Dao.Impl;

import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import redis.clients.johm.JOhm;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisUserDaoImpl implements UserDao {

    private static Logger log = LoggerFactory.getLogger(RedisUserDaoImpl.class);

    @Override
    public Collection<User> getAllUser() {
        return JOhm.getAll(User.class);
    }

    @Override
    public Collection<User> getAllUserCensored() {
        return JOhm.find(User.class, "findable", true,
                "hashedPw", "salt", "phone", "sessionId", "confirmationLink");
    }

    @Override
    public User getUserById(long id) {
        return JOhm.get(User.class, id);
    }

    @Override
    public User getUserByMail(String mail){
        log.debug("Getting user by mail {}", mail);
        List<User> users = JOhm.find(User.class, "mail", mail);
        if (users.isEmpty()) {
            log.debug("No user found for mail {}", mail);
            return null;
        }
        if (users.size() > 1) {
            //this shouldn't happen
            //if this happens, someone screwed up the database
            //you should look why it's possible to store multiple users with same mail
            //TODO Nevertheless proper exception handling is required here
            log.error("Multiple users found for mail {}", mail);
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserBySessionId(String sessionId) {
        List<User> users = JOhm.find(User.class, "sessionId", sessionId);
        if (users.isEmpty()) {
            log.debug("No user found for sessionId {}", sessionId);
            return null;
        }
        if (users.size() > 1) {
            //this shouldn't happen
            //if this happens, someone screwed up the database
            //you should look why it's possible to store multiple users with same sessionId
            //TODO Nevertheless proper exception handling is required here
            log.error("Multiple users found for sessionId {}", sessionId);
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByFacebookId(String id) {
        List<User> users = JOhm.find(User.class, "facebookId", id);
        if (users.isEmpty()) {
            log.debug("No user found for facebookId {}", id);
            return null;
        }
        if (users.size() > 1) {
            //this shouldn't happen
            //if this happens, someone screwed up the database
            //you should look why it's possible to store multiple users with same sessionId
            //TODO Nevertheless proper exception handling is required here
            log.error("Multiple users found for facebookId {}", id);
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByGoogleId(String id) {
        List<User> users = JOhm.find(User.class, "googleId", id);
        if (users.isEmpty()) {
            log.debug("No user found for googleId {}", id);
            return null;
        }
        if (users.size() > 1) {
            //this shouldn't happen
            //if this happens, someone screwed up the database
            //you should look why it's possible to store multiple users with same sessionId
            //TODO Nevertheless proper exception handling is required here
            log.error("Multiple users found for googleId {}", id);
            return null;
        }
        return users.get(0);
    }

    @Override
    public boolean removeUserById(long id) {
        return JOhm.delete(User.class, id, true, true);
    }

    @Override
    public User updateUser(User user) {
        return JOhm.save(user);
    }

    @Override
    public User insertUserToDb(User user) {
        user.setTime(new Date().getTime());
        return JOhm.save(user);
    }

}
