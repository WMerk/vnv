package com.vnv.dao;

import com.vnv.entity.User;

import java.util.Collection;

public interface UserDao {

    Collection<User> getAllUser();

    Collection<User> getAllUserCensored();

    User getUserById(long id);

    User getUserByMail(String mail);

    User getUserBySessionId(String sessionId);

    User getUserByFacebookId(String id);

    User getUserByGoogleId(String id);

    boolean removeUserById(long id);

    User updateUser(User user);

    User insertUserToDb(User user);

}
