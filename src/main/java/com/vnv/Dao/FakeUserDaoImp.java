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
    private static int id = 4;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1,new User(){
                    {
                        setUid(1L);
                        setFirstName("Patrick");
                        setMail("patrick@gmail.com");
                    }
                });
                put(2,new User(){
                    {
                        setUid(2L);
                        setFirstName("Gabriel");
                        setMail("gabriel@gmail.com");
                    }
                });
                put(3,new User(){
                    {
                        setUid(3L);
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
    public User getUserByMail(String mail) {
        for (int i=1; i<id; i++) {
            User u = users.get(i);
            if (mail.equals(u.getMail()))
                return u;
        }
        return null;
    }

    @Override
    public User getUserBySessionId(String sessionId) {
        for (int i=1; i<id; i++) {
            User u = users.get(i);
            if (sessionId.equals(u.getSessionId()))
                return u;
        }
        return null;
    }

    @Override
    public void removeUserById(int id) {
        users.remove(id);
    }

    @Override
    public void updateUser(User user) {
        users.put(user.getUid().intValue(), user);
    }

    @Override
    public void insertUserToDb(User user) {
        user.setUid(new Long(id));
        users.put(id,user);
        id++;
    }
}
