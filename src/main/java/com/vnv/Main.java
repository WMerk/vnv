package com.vnv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Waldemar on 03.11.2016.
 */
@SpringBootApplication
public class Main {

    @Autowired
    public Database db;// = new Database();

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class,args);
    }

}
