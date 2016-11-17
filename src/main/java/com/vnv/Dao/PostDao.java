package com.vnv.Dao;

import com.vnv.Entity.Post;
import com.vnv.Entity.User;

import java.util.Collection;

public interface PostDao {

    /**
     * gets the post with th specified id from the database
     * @param id    the id of the post to be returned
     * @return the post with the specified id
     */
    Post getPostById(long id);

    /**
     * gets all posts from the database
     * @return Collection fo all posts
     */
    Collection<Post> getAllPosts();

    /**
     * gets all posts from a given user
     * @param user  the user whose posts should be returned
     * @return  Collection of user's posts
     */
    Collection<Post> getPostsForUser(User user);
    /**
     * gets all offers from a given user
     * @param user  the user whose offers should be returned
     * @return  Collection of user's offers
     */
    Collection<Post> getOffersForUser(User user);
    /**
     * gets all requests from a given user
     * @param user  the user whose requests should be returned
     * @return  Collection of user's requests
     */
    Collection<Post> getRequestsForUser(User user);

    //TODO

    /**
     * inserts a post into the database
     * @param post  the post to be inserted
     */
    void insertPost(Post post);

    /**
     * updates a post in the database
     * @param post  the updated post that will be updated in the database
     */
    void updatePost(Post post);

    /**
     * removes the post with the given id from the database
     * @param id    the id of the post to be removed
     */
    void deletePost(long id);

}
