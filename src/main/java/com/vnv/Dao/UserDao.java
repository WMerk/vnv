package com.vnv.Dao;

import com.vnv.Entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUser();

    User getUserById(int id);

    User getUserByMail(String mail);

    User getUserBySessionId(String sessionId);

    void removeUserById(int id);

    void updateUser(User user);

    void insertUserToDb(User user);

}
