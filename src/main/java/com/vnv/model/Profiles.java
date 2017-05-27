package com.vnv.model;

import com.vnv.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class Profiles {

    @Autowired
    Environment environment;

    private static String[] profiles = Main.getProfiles();

    @PostConstruct
    public void init() {
        profiles = environment.getActiveProfiles();
    }

    public static boolean checkActiveProfile(String profileName) {
        if(Arrays.asList(profiles).contains(profileName)) {
            return true;
        }
        return false;
    }

    public static boolean checkFakeActive() {
        return checkActiveProfile("fake");
    }

    public static boolean checkDebugActive() {
        return checkActiveProfile("debug");
    }

    public static boolean checkProdActive() {
        return checkActiveProfile("prod");
    }
}
