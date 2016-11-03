package com.vnv.Entity;


import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;
import redis.clients.johm.Model;

import java.util.Date;

/**
 * Created by Gabriel on 01.11.2016.
 */
@Model
public class Message {

    @Id
    private Long id;
    @Attribute
    @Indexed
    private long fromUid;
    @Attribute
    @Indexed
    private long toUid;
    @Attribute
    private long time = new Date().getTime();
    //private Date date = new Date();
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

    public long getFromUid() {
        return fromUid;
    }

    public void setFromUid(long fromUid) {
        this.fromUid = fromUid;
    }

    public long getToUid() {
        return toUid;
    }

    public void setToUid(long toUid) {
        this.toUid = toUid;
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
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

