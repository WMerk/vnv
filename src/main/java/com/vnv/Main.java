package com.vnv;

import com.vnv.Model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


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
