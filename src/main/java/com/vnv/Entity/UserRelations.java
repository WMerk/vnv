package com.vnv.Entity;

import java.util.Collection;

public class UserRelations {

    private User user;
    private Collection<User> friends;
    private Collection<User> sentRequests;
    private Collection<User> receivedRequests;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }

    public Collection<User> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(Collection<User> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public Collection<User> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(Collection<User> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    @Override
    public String toString() {
        return "UserRelations{" +
                "user=" + user +
                ", friends=" + friends +
                ", sentRequests=" + sentRequests +
                ", receivedRequests=" + receivedRequests +
                '}';
    }
}
