package com.vnv.Dao;

import com.vnv.Entity.User;
import com.vnv.Entity.UserRelations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Qualifier("fakeData")
public class FakeUserRelDaoImpl implements UserRelDao {

    public static HashMap<Integer, UserRelations> relations;

    static {
        relations = new HashMap<Integer, UserRelations>() {
            {
                put(1, new UserRelations() {
                    {
                        setUser(new User(){
                            {
                                setUid(1L);
                                setFirstName("test");
                                setLastName("user");
                                setMail("test@test.de");
                            }
                        }
                        );

                    }
                });
            }
        };
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addFriend(User user, User friend) {

    }

    @Override
    public void removeFriend(User user, User friend) {

    }

    @Override
    public void addRequest(User requestFrom, User requestTo) {

    }

    @Override
    public void removeRequest(User requestFrom, User requestTo) {

    }

    @Override
    public void deleteUser(long uid) {

    }
}
