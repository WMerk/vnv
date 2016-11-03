package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements UserDao {


    @Override
    public Collection<User> getAllUser() {
        return new ArrayList<User>(){
            {
                add(new User(1,"Mario","Nothing"));
            }
        };
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
