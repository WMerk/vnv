package com.vnv.service;

import com.vnv.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageDao messageDao;

}
