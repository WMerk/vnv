package com.vnv.Dao;

import com.vnv.Entity.User;
import com.vnv.Model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeUserDaoImp implements UserDao {

    public static Map<Integer,User> users;
    private static int id = 2;

    private static String[] demoHashPw = Password.hashPassword("test");

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1,new User(){
                    {
                        setUid(1L);
                        setFirstName("test");
                        setLastName("user");
                        setMail("test@test.de");
                        setTime(0);
                        setHashedPw(demoHashPw[0]);
                        setSalt(demoHashPw[1]);
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
    public User getUserById(long id) {
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
    public void removeUserById(long id) {
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
