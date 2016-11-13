package com.vnv.Dao;

import com.vnv.Entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUser();

    User getUserById(long id);

    User getUserByMail(String mail);

    User getUserBySessionId(String sessionId);

    void removeUserById(long id);

    void updateUser(User user);

    void insertUserToDb(User user);

    Collection<User> searchUser(String query);

}
