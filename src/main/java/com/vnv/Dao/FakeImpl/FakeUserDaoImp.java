package com.vnv.Dao.FakeImpl;

import com.vnv.Dao.UserDao;
import com.vnv.Entity.User;
import com.vnv.Model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakeUserDaoImp implements UserDao {

    public static Map<Long,User> users;
    private static long id = 2;

    private static String[] demoHashPw = Password.hashPassword("test");

    static {
        users = new HashMap<Long, User>(){
            {
                put(1L,new User(){
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
        for (long i=1; i<id; i++) {
            User u = getUserById(i);
            if (u!=null)
                if (mail.equals(u.getMail()))
                    return u;
        }
        return null;
    }

    @Override
    public User getUserBySessionId(String sessionId) {
        for (int i=1; i<id; i++) {
            User u = getUserById(i);
            if (u!=null) {
                if (sessionId.equals(u.getSessionId()))
                    return u;
            }
        }
        return null;
    }

    @Override
    public boolean removeUserById(long id) {
        users.remove(id);
        return true;
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getUid().longValue(), user);
        return getUserById(user.getUid());
    }

    @Override
    public User insertUserToDb(User user) {
        user.setUid(id);
        id++;
        users.put(user.getUid(),user);
        return getUserById(user.getUid());
    }

    @Override
    public Collection<User> searchUser(String query) {
        //TODO
        return null;
    }
}
