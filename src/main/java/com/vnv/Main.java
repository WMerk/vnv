package com.vnv;

import com.vnv.Model.Database;
import com.vnv.Service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class,args);
        ctx.getBean(PostService.class).initCategories();
    }

    @Profile("prod")
    @PostConstruct
    private static void initDB() {
        log.debug("Init DB");
        Database db = new Database();
    }

}
