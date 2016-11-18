package com.vnv.Dao.Impl;

import com.vnv.Dao.MessageDao;
import com.vnv.Entity.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisMessageDaoImpl implements MessageDao {

    @Override
    public Message getMessageById(long id) {
        return null;
    }

    @Override
    public void insertMessage(Message message) {

    }

    @Override
    public void deleteMessageById(long id) {

    }

    @Override
    public Collection<Message> getAllMessages() {
        return null;
    }

    @Override
    public Collection<Message> getMessagesForUser(long uid) {
        return null;
    }

    @Override
    public Collection<Message> getMessagesForSender(long uid) {
        return null;
    }

    @Override
    public Collection<Message> getMessagesForReceiver(long uid) {
        return null;
    }
}