package com.vnv.Dao;

import com.vnv.Entity.Post;
import com.vnv.Entity.User;

import java.util.Collection;

public interface PostDao {

    Post getPostById(long id);

    Collection<Post> getAllPosts();

    Collection<Post> getPostsForUser(User user);
    Collection<Post> getOffersForUser(User user);
    Collection<Post> getRequestsForUser(User user);

    //TODO

    void insertPost(Post post);
    void updatePost(Post post);
    void deletePost(long id);

}
