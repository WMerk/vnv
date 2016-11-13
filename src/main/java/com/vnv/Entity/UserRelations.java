package com.vnv.Entity;

import java.util.Collection;

public class UserRelations {

    private long uid;
    private Collection<User> friends;
    private Collection<User> sentRequests;
    private Collection<User> receivedRequests;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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
                "uid=" + uid +
                ", friends=" + friends +
                ", sentRequests=" + sentRequests +
                ", receivedRequests=" + receivedRequests +
                '}';
    }
}
