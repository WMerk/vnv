package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("neo4j")
public class neo4jUserImpl implements UserDao {


    @Override
    public Collection<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void removeUserById(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void insertUserToDb(User user) {

    }
}
