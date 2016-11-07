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
                        setUid(12L);
                        setFirstName("Patrick");
                        setMail("patrick@gmail.com");
                    }
                });
                put(2,new User(){
                    {
                        setUid(13L);
                        setFirstName("Gabriel");
                        setMail("gabriel@gmail.com");
                    }
                });
                put(3,new User(){
                    {
                        setUid(14L);
                        setFirstName("Waldemar");
                        setMail("waldemar@gmail.com");
                    }
                });

            }
        };
    }


    @Override
    public Collection<User> getAllUser() {
        return users.values();
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public void removeUserById(int id) {
        users.remove(id);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void insertUserToDb(User user) {
        users.put(70,user);

    }
}
