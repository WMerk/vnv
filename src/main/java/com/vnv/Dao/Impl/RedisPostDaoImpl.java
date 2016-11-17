package com.vnv.Dao.Impl;

import com.vnv.Dao.PostDao;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import redis.clients.johm.JOhm;
import redis.clients.johm.NVField;

import java.util.Collection;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisPostDaoImpl implements PostDao {

    @Override
    public Post getPostById(long id) {
        return JOhm.get(Post.class, id);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return JOhm.getAll(Post.class);
    }

    @Override
    public Collection<Post> getPostsForUser(User user) {
        return JOhm.find(Post.class, "uid", user.getUid());
    }

    @Override
    public Collection<Post> getOffersForUser(User user) {
        return JOhm.find(Post.class, new NVField("uid", user.getUid()), new NVField("type", "offer"));
    }

    @Override
    public Collection<Post> getRequestsForUser(User user) {
        return JOhm.find(Post.class, new NVField("uid", user.getUid()), new NVField("type", "request"));
    }

    @Override
    public void insertPost(Post post) {
        JOhm.save(post);
    }

    @Override
    public void updatePost(Post post) {
        JOhm.save(post);
    }

    @Override
    public void deletePost(long id) {
        JOhm.delete(Post.class, id, true, true);
    }
}
