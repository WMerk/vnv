package com.vnv.Entity;

import org.json.JSONObject;
import redis.clients.johm.*;

import java.util.Date;

@Model
@SupportAll
public class Category {

    @Id
    private Long id;
    @Attribute
    @Indexed
    private String name;
    @Attribute
    private long time = new Date().getTime();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public JSONObject toJSON() {
        return new JSONObject(this);
    }
}
