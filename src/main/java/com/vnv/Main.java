package com.vnv;

import com.vnv.model.Database;
import com.vnv.model.Profiles;
import com.vnv.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static String[] profiles;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class,args);
        ctx.getBean(PostService.class).initCategories();
        profiles = ctx.getEnvironment().getActiveProfiles();
        if(Profiles.checkProdActive()) {
            ctx.getBean(Database.class).init();
        }
        if(Profiles.checkFakeActive()) {
            addFakeUser();
        }
    }

    @Profile("fake")
    private static void addFakeUser() {
        log.debug("Adding fake users");
       // Fake f = new Fake();
       // f.makeFakeDbEntries(100);
    }

    public static String[] getProfiles() {
        return profiles;
    }

    public static void setProfiles(String[] profiles) {
        Main.profiles = profiles;
    }
}
