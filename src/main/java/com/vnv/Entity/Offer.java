package com.vnv.Entity;

import redis.clients.johm.Attribute;
import redis.clients.johm.Id;
import redis.clients.johm.Indexed;

public class Offer {

    @Id
    private Long id;
    @Attribute
    @Indexed
    private long uid;
    @Attribute
    @Indexed
    private String type;
    @Attribute
    @Indexed
    private String offerName;
    @Attribute
    @Indexed
    private String category;
    @Attribute
    @Indexed
    private String period;
    @Attribute
    private String picPath;
    @Attribute
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", uid=" + uid +
                ", type='" + type + '\'' +
                ", offerName='" + offerName + '\'' +
                ", category='" + category + '\'' +
                ", period='" + period + '\'' +
                ", picPath='" + picPath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
