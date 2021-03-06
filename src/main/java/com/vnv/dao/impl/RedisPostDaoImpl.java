package com.vnv.dao.impl;

import com.vnv.dao.PostDao;
import com.vnv.dao.UserDao;
import com.vnv.entity.Post;
import com.vnv.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import redis.clients.johm.JOhm;
import redis.clients.johm.NVField;

import java.util.Collection;
import java.util.Date;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisPostDaoImpl implements PostDao {

    @Autowired
    private UserDao userDao;

    @Override
    public Post getPostById(long id) {
        return JOhm.get(Post.class, id);
    }

    @Override
    public Collection<Post> getAllPosts() {
        Collection<Post> posts = JOhm.getAll(Post.class);
        for (Post p : posts) {
            p.setUser(p.getUser().toPublic());
            p.setCreationDate(df.format(new Date(p.getCreationTime())));
        }
        return posts;
    }

    @Override
    public Collection<Post> getPostsForUser(User user) {
        Collection<Post> posts = JOhm.find(Post.class, "user", user.getUid());
        for (Post p : posts) {
            p.setUser(p.getUser().toPublic());
            p.setCreationDate(df.format(new Date(p.getCreationTime())));
        }
        return posts;
    }

    @Override
    public Collection<Post> getOffersForUser(User user) {
        Collection<Post> posts = JOhm.find(Post.class, new NVField("user", user.getUid()), new NVField("type", "offer"));
        for (Post p : posts) {
            p.setUser(p.getUser().toPublic());
            p.setCreationDate(df.format(new Date(p.getCreationTime())));
        }
        return posts;
    }

    @Override
    public Collection<Post> getRequestsForUser(User user) {
        Collection<Post> posts = JOhm.find(Post.class, new NVField("user", user.getUid()), new NVField("type", "request"));
        for (Post p : posts) {
            p.setUser(p.getUser().toPublic());
            p.setCreationDate(df.format(new Date(p.getCreationTime())));
        }
        return posts;
    }

    @Override
    public Post insertPost(Post post) {
        return JOhm.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return JOhm.save(post);
    }

    @Override
    public boolean deletePost(long id) {
        return JOhm.delete(Post.class, id, true, true);
    }
}
