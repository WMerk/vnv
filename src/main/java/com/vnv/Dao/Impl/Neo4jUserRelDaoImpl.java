package com.vnv.Dao.Impl;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Model.Database;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("neo4j")
@Profile("prod")
public class Neo4jUserRelDaoImpl implements UserRelDao {

    private static Logger log = LoggerFactory.getLogger(Neo4jUserRelDaoImpl.class);

    @Autowired
    UserDao userDao;

    private String addQuery = "CREATE (a:User {firstName:'%s', lastName:'%s', mail:'%s', pic:'%s', uid:'%d'})";
    private String updateUserQuery = "MATCH (a:User) " +
            "WHERE a.uid='%s' " +
            "SET a.firstName='%s', a.lastName='%s', a.mail='%s', a.pic='%s' " +
            "return a";
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
    private String getFriendsQuery = "MATCH (a:User)-[r:ARE_FRIENDS]-(b:User) " +
            "WHERE a.uid = '%d' " +
            "return b.uid as uid, b.firstName as firstName, b.lastName as lastName, b.mail as mail, b.pic as pic";
    private String getNonRelatedUsersQuery = "MATCH (a:User) " +
            "OPTIONAL MATCH (a)-[r]-(b:User) " +
            "WHERE r IS null AND b.uid='%d' " +
            "return a.uid as uid, a.firstName as firstName, a.lastName as lastName, a.mail as mail, a.pic as pic";

    @Override
    public void addUser(User user) {
        log.debug("Adding user {} to neo4j", user);
        String query = String.format(addQuery,
                user.getFirstName(), user.getLastName(), user.getMail(), user.getPicPath(), user.getUid());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
    }

    @Override
    public boolean updateUser(User updated, long uid) {
        log.debug("updating user with uid {} to {}", uid, updated);
        String query = String.format(updateUserQuery,
                updated.getUid(), updated.getFirstName(), updated.getLastName(), updated.getMail(), updated.getPicPath());
        log.debug("Query is {}", query);
        Database.neo4j.run(query);
        return true;
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
        log.debug("getting friends for user with uid {} from neo4j", user.getUid());
        String query = String.format(getFriendsQuery, user.getUid());
        log.debug("Query is {}", query);
        StatementResult res = Database.neo4j.run(query);
        List<User> friends = new ArrayList<>();
        while (res.hasNext()) {
            Record record = res.next();
            //log.debug(record.toString());
            //for (String key:record.keys())System.out.println(key);
            if (record.containsKey("b.uid")) {
                String uidString = record.get("b.uid").asString();
                long uid = Long.valueOf(uidString);
                User u = new User();
                u.setUid(uid);
                u.setFirstName(record.get("firstName").asString());
                u.setLastName(record.get("lastName").asString());
                u.setMail(record.get("mail").asString());
                u.setPicPath(record.get("pic").asString());
                friends.add(u);
            } else
                log.error(record.toString());
        }
        return friends;
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

    @Override
    public Collection<User> getNonRelatedUsers(User user) {
        log.debug("getting non related users for user with uid {} from neo4j", user.getUid());
        String query = String.format(getNonRelatedUsersQuery, user.getUid());
        log.debug("Query is {}", query);
        StatementResult res = Database.neo4j.run(query);
        /*
        List<Record> list = res.list();
        log.debug(list.toString());
        JSONArray array = new JSONArray();
        log.debug(array.toString());
        */
        List<User> users = new ArrayList<>();
        while (res.hasNext()) {
            Record record = res.next();
            //log.debug(record.toString());
            //for (String key:record.keys())System.out.println(key);
            if (record.containsKey("uid")) {
                String uidString = record.get("uid").asString();
                long uid = Long.valueOf(uidString);
                User u = new User();
                u.setUid(uid);
                u.setFirstName(record.get("firstName").asString());
                u.setLastName(record.get("lastName").asString());
                u.setMail(record.get("mail").asString());
                u.setPicPath(record.get("pic").asString());
                users.add(u);
                //users.add(userDao.getUserById(uid));
            } else
                log.error(record.toString());
        }
        return users;
    }
}
