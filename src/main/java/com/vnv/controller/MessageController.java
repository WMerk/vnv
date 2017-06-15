package com.vnv.controller;

import com.vnv.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

}
