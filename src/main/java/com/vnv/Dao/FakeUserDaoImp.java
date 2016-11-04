package com.vnv.Dao;

import com.vnv.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeUserDaoImp implements UserDao {

    public static Map<Integer,User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1,new User(){
                    {
                        setFirstName("Patrick");
                        setMail("patrick@gmail.com");
                    }
                });
                put(1,new User(){
                    {
                        setFirstName("Gabriel");
                        setMail("gabriel@gmail.com");
                    }
                });
                put(1,new User(){
                    {
                        setFirstName("Waldemar");
                        setMail("waldemar@gmail.com");
                    }
                });

            }
        };
    }


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
