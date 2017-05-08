package com.vnv.Entity;

import org.json.JSONObject;
import redis.clients.johm.*;

import java.util.Date;

@Model
@SupportAll
public class Post {

    @Id
    private Long id;
    @Reference
    @Indexed
    private User user;
    @Attribute
    @Indexed
    private String type;
    @Attribute
    @Indexed
    private String flavour;
    @Attribute
    @Indexed
    private String postName;
    @Reference
    @Indexed
    private Category category;
    @Attribute
    @Indexed
    private String status;
    @Attribute
    @Indexed
    private String period;
    @Attribute
    private String picPath;
    @Attribute
    private String description;
    @Attribute
    private long creationTime = new Date().getTime();
    private String creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", type='" + type + '\'' +
                ", flavour='" + flavour + '\'' +
                ", postName='" + postName + '\'' +
                ", category=" + category +
                ", status='" + status + '\'' +
                ", period='" + period + '\'' +
                ", picPath='" + picPath + '\'' +
                ", description='" + description + '\'' +
                ", creationTime=" + creationTime +
                ", creationDate=" + creationDate +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject(this);
        return json;
    }
}
