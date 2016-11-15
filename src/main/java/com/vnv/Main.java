package com.vnv;

import com.vnv.Model.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    public Database db;

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class,args);
    }

    @Profile("prod")
    @PostConstruct
    private void initDB() {
        log.debug("Init DB");
        db = new Database();
    }

}
