package com.vnv.Dao.FakeImpl;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Entity.UserRelations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakeUserRelDaoImpl implements UserRelDao {

    @Autowired
    UserDao userDao;

    public static HashMap<Long, UserRelations> relations;

    static {
        relations = new HashMap<Long, UserRelations>() {
            {
                put(1L, new UserRelations() {
                    {
                        setUid(1L);

                    }
                });
            }
        };
    }

    @Override
    public void addUser(User user) {
        relations.put(user.getUid(), new UserRelations(){{setUid(user.getUid());}});
    }

    @Override
    public boolean updateUser(User updated, long uid) {
        return true;
    }

    @Override
    public void addFriend(User user, User friend) {
        UserRelations relation = relations.get(user.getUid());
        Collection<User> friends = relation.getFriends();
        if (friends == null)
            friends = new ArrayList<>();
        friends.add(friend);
        relation.setFriends(friends);
        relations.put(user.getUid(), relation);

        relation = relations.get(friend.getUid());
        friends = relation.getFriends();
        if (friends == null)
            friends = new ArrayList<>();
        friends.add(user);
        relation.setFriends(friends);
        relations.put(friend.getUid(), relation);
    }

    @Override
    public void removeFriend(User user, User friend) {
        UserRelations relation = relations.get(user.getUid());
        Collection<User> friends = relation.getFriends();
        if (friends == null)
            return;
        friends.remove(friend);
        relation.setFriends(friends);
        relations.put(user.getUid(), relation);
    }

    @Override
    public void addRequest(User requestFrom, User requestTo) {
        UserRelations relation = relations.get(requestTo.getUid());
        Collection<User> recs = relation.getReceivedRequests();
        if (recs==null)
            recs = new ArrayList<>();
        recs.add(requestFrom);
        relation.setReceivedRequests(recs);
        relations.put(requestTo.getUid(), relation);

        relation = relations.get(requestFrom.getUid());
        Collection<User> sents = relation.getSentRequests();
        if (sents==null)
            sents = new ArrayList<>();
        sents.add(requestTo);
        relation.setSentRequests(sents);
        relations.put(requestFrom.getUid(), relation);
    }

    @Override
    public void removeRequest(User requestFrom, User requestTo) {
        UserRelations relation = relations.get(requestTo.getUid());
        Collection<User> recs = relation.getReceivedRequests();
        if (recs==null)
            return;
        recs.remove(requestFrom);
        relation.setReceivedRequests(recs);
        relations.put(requestTo.getUid(), relation);

        relation = relations.get(requestFrom.getUid());
        Collection<User> sents = relation.getSentRequests();
        if (sents==null)
            return;
        sents.remove(requestTo);
        relation.setSentRequests(sents);
        relations.put(requestFrom.getUid(), relation);
    }

    @Override
    public void deleteUser(long uid) {
        relations.remove(uid);
    }

    @Override
    public Collection<User> getFriends(User user) {
        return relations.get(user.getUid()).getFriends();
    }

    @Override
    public Collection<User> getRequestsRecv(User user) {
        return relations.get(user.getUid()).getReceivedRequests();
    }

    @Override
    public Collection<User> getRequestsSent(User user) {
        return relations.get(user.getUid()).getSentRequests();
    }

    @Override
    public Collection<User> getNonRelatedUsers(User user) {
        Collection<User> allUsers = userDao.getAllUser();
        Collection<User> friends = getFriends(user);
        Collection<User> recv = getRequestsRecv(user);
        Collection<User> sent = getRequestsSent(user);
        if (friends!=null)
            allUsers.removeAll(friends);
        if (recv!=null)
            allUsers.removeAll(recv);
        if (sent!=null)
            allUsers.removeAll(sent);
        return allUsers;
    }
}
