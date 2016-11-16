package com.vnv.Dao.FakeImpl;

import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Entity.UserRelations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakeUserRelDaoImpl implements UserRelDao {

    public static HashMap<Integer, UserRelations> relations;

    static {
        relations = new HashMap<Integer, UserRelations>() {
            {
                put(1, new UserRelations() {
                    {
                        setUid(1L);

                    }
                });
            }
        };
    }

    @Override
    public void addUser(User user) {
        relations.put(user.getUid().intValue(), new UserRelations(){{setUid(user.getUid());}});
    }

    @Override
    public void addFriend(User user, User friend) {
        UserRelations relation = relations.get(user.getUid().intValue());
        relation.getFriends().add(friend);
        relations.put(user.getUid().intValue(), relation);
    }

    @Override
    public void removeFriend(User user, User friend) {
        UserRelations relation = relations.get(user.getUid().intValue());
        relation.getFriends().remove(friend);
        relations.put(user.getUid().intValue(), relation);
    }

    @Override
    public void addRequest(User requestFrom, User requestTo) {
        UserRelations relation = relations.get(requestTo.getUid().intValue());
        relation.getReceivedRequests().add(requestFrom);
        relations.put(requestTo.getUid().intValue(), relation);

        relation = relations.get(requestFrom.getUid().intValue());
        relation.getSentRequests().add(requestTo);
        relations.put(requestFrom.getUid().intValue(), relation);
    }

    @Override
    public void removeRequest(User requestFrom, User requestTo) {
        UserRelations relation = relations.get(requestTo.getUid().intValue());
        relation.getReceivedRequests().remove(requestFrom);
        relations.put(requestTo.getUid().intValue(), relation);

        relation = relations.get(requestFrom.getUid().intValue());
        relation.getSentRequests().remove(requestTo);
        relations.put(requestFrom.getUid().intValue(), relation);
    }

    @Override
    public void deleteUser(long uid) {
        relations.remove(uid);
    }

    @Override
    public Collection<User> getFriends(User user) {
        return relations.get(user.getUid().intValue()).getFriends();
    }

    @Override
    public Collection<User> getRequestsRecv(User user) {
        return relations.get(user.getUid().intValue()).getReceivedRequests();
    }

    @Override
    public Collection<User> getRequestsSent(User user) {
        return relations.get(user.getUid().intValue()).getSentRequests();
    }
}
