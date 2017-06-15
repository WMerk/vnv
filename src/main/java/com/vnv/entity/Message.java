package com.vnv.entity;


import redis.clients.johm.*;

import java.util.Date;

@Model
public class Message {

    @Id
    private Long id;
    @Reference
    @Indexed
    private User sender;
    @Reference
    @Indexed
    private User receiver;
    @Attribute
    private long time = new Date().getTime();
    @Attribute
    private String subject;
    @Attribute
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

