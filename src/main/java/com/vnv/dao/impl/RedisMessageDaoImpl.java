package com.vnv.dao.impl;

import com.vnv.model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import com.vnv.dao.MessageDao;
import com.vnv.entity.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisMessageDaoImpl implements MessageDao {

    @Autowired
    Database db;

    @Override
    public Message getMessageById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public void insertMessage(Message message) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteMessageById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Message> getAllMessages() {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Message> getMessagesForUser(long uid) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Message> getMessagesForSender(long uid) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Message> getMessagesForReceiver(long uid) {
        throw new NotImplementedException();
    }
}
