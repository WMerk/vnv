package com.vnv;

import com.vnv.Model.Database;
import com.vnv.Model.Fake;
import com.vnv.Model.Profiles;
import com.vnv.Service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static String[] profiles;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class,args);
        ctx.getBean(PostService.class).initCategories();
        profiles = ctx.getEnvironment().getActiveProfiles();
        if(Profiles.checkProdActive()) {
            initDB();
        }
        if(Profiles.checkFakeActive()) {
            addFakeUser();
        }
    }

    @Profile("prod")
    private static void initDB() {
        log.debug("Init DB");
        Database db = new Database();
    }

    @Profile("fake")
    private static void addFakeUser() {
        log.debug("Adding fake users");
        Fake f = new Fake();
        f.makeFakeDbEntries(100);
    }

}
