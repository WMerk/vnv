package com.vnv.Dao;

import com.vnv.Entity.User;

import java.util.Collection;

public interface UserRelDao {

    void addUser(User user);
    void addFriend(User user, User friend);
    void removeFriend(User user, User friend);
    void addRequest(User requestFrom, User requestTo);
    void removeRequest(User requestFrom, User requestTo);
    void deleteUser(long uid);

    Collection<User> getFriends(User user);
    Collection<User> getRequestsRecv(User user);
    Collection<User> getRequestsSent(User user);
}
