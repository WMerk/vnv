package com.vnv.dao;

import com.vnv.entity.User;

import java.util.Collection;

public interface UserRelDao {

    void addUser(User user);
    boolean updateUser(User updated, long uid);
    void addFriend(User user, User friend);
    void removeFriend(User user, User friend);
    void addRequest(User requestFrom, User requestTo);
    void removeRequest(User requestFrom, User requestTo);
    void deleteUser(long uid);

    Collection<User> getFriends(User user);
    Collection<User> getRequestsRecv(User user);
    Collection<User> getRequestsSent(User user);
    Collection<User> getNonRelatedUsers(User user);
}
