package com.vnv.Dao;

import com.vnv.Entity.User;
import com.vnv.Model.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("neo4j")
public class Neo4jUserRelDaoImpl implements UserRelDao {

    private static Logger log = LoggerFactory.getLogger(Neo4jUserRelDaoImpl.class);

    private String addQuery = "CREATE (a:User {name:'%s', uid:'%d'})";
    private String addFriendQuery = "MATCH (a:User),(b:User)" +
            "WHERE a.uid = '%d' AND b.uid = '%d'" +
            "CREATE (a)-[r:ARE_FRIENDS]->(b)" +
            "RETURN r";
    private String addFriendRequestQuery = "MATCH (a:User),(b:User)" +
            "WHERE a.uid = '%d' AND b.uid = '%d'" +
            "CREATE (a)-[r:REQUEST]->(b)" +
            "RETURN r";
    private String deleteRequestQuery = "MATCH (a:User)-[r:REQUEST]-(b:User)" +
            "WHERE a.uid = '%d' AND b.uid = '%d'" +
            "DELETE r";
    private String deleteFriendQuery = "MATCH (a:User)-[r:ARE_FRIENDS]-(b:User)" +
            "WHERE a.uid = '%d' AND b.uid = '%d'" +
            "DELETE r";
    private String deleteUserQuery = "MATCH (a:User) " +
            "WHERE a.uid = '%d'" +
            "DETACH DELETE a";

    @Override
    public void addUser(User user) {
        log.debug("Adding user {} to neo4j", user);
        String query = String.format(addQuery, user.getFirstName()+" "+user.getLastName(), user.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public void addFriend(User user, User friend) {
        log.debug("Adding friend relation between user {} and user {} to neo4j", user, friend);
        String query = String.format(addFriendQuery, user.getUid(), friend.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public void removeFriend(User user, User friend) {
        log.debug("Removing friend relation between user {} and user {} from neo4j", user, friend);
        String query = String.format(deleteFriendQuery, user.getUid(), friend.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public void addRequest(User requestFrom, User requestTo) {
        log.debug("Adding friend request from user {} to user {} to neo4j", requestFrom, requestTo);
        String query = String.format(addFriendRequestQuery, requestFrom.getUid(), requestTo.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public void removeRequest(User requestFrom, User requestTo) {
        log.debug("Removing friend request from user {} to user {} from neo4j", requestFrom, requestTo);
        String query = String.format(deleteRequestQuery, requestFrom.getUid(), requestTo.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public void deleteUser(long uid) {
        log.debug("Deleting user with uid {} from neo4j", uid);
        String query = String.format(deleteUserQuery, uid);
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public Collection<User> getFriends(User user) {
        //TODO
        return null;
    }

    @Override
    public Collection<User> getRequestsRecv(User user) {
        //TODO
        return null;
    }

    @Override
    public Collection<User> getRequestsSent(User user) {
        //TODO
        return null;
    }
}
