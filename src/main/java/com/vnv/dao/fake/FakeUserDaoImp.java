package com.vnv.dao.fake;

import com.vnv.dao.UserDao;
import com.vnv.entity.User;
import com.vnv.model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public Collection<User> getAllUserCensored() {
        List<User> res = new ArrayList<User>(users.values());
        /*
        for (User u:res) {
            u.setPassword(null);
            u.setNewPassword(null);
            u.setSalt(null);
            u.setHashedPw(null);
            u.setPhone(null);
            u.setConfirmationLink(null);
            u.setSessionId(null);
        }*/
        return res;
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
    public User getUserByFacebookId(String id) {
        for (int i=1; i<this.id; i++) {
            User u = getUserById(i);
            if (u!=null) {
                if (id.equals(u.getFacebookId()))
                    return u;
            }
        }
        return null;
    }

    @Override
    public User getUserByGoogleId(String id) {
        for (int i=1; i<this.id; i++) {
            User u = getUserById(i);
            if (u!=null) {
                if (id.equals(u.getGoogleId()))
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
        user.setTime(new Date().getTime());
        user.setUid(id);
        id++;
        users.put(user.getUid(),user);
        return getUserById(user.getUid());
    }

}
