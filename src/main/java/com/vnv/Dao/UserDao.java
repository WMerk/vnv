package com.vnv.Dao;

import com.vnv.Entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUser();

    User getUserById(long id);

    User getUserByMail(String mail);

    User getUserBySessionId(String sessionId);

    boolean removeUserById(long id);

    User updateUser(User user);

    User insertUserToDb(User user);

    Collection<User> searchUser(String query);

}
