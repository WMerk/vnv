package com.vnv.dao;

import com.vnv.entity.Message;

import java.util.Collection;

public interface MessageDao {

    /**
     * returns the Message with the given id
     * @param id    the id of the message to be returned
     * @return  the message with the specified id
     */
    Message getMessageById(long id);
    /**
     * inserts the given message to the database
     * @param message   the message to be inserted
     */
    void insertMessage(Message message);
    /**
     * deletes the message with the given id
     * @param id    the id of the message to be deleted
     */
    void deleteMessageById(long id);

    /**
     * gets all messages from the database
     * @return  Collection of all messages
     */
    Collection<Message> getAllMessages();
    /**
     * gets all Messages sent and received by a given user
     * @param uid   uid of the user
     * @return  Collection of user's Messages
     */
    Collection<Message> getMessagesForUser(long uid);
    /**
     * gets all messages sent by a given user
     * @param uid   uid of the sender
     * @return  Collection of user's sent Messages
     */
    Collection<Message> getMessagesForSender(long uid);
    /**
     * gets all messages received by a given user
     * @param uid   uid of the receiver
     * @return  Collection of user's received Messages
     */
    Collection<Message> getMessagesForReceiver(long uid);

}
