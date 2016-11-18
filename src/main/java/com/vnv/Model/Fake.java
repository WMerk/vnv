package com.vnv.Model;


import com.github.javafaker.Faker;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;

import java.util.Locale;
import java.util.Random;

public class Fake {

    public static Faker faker = new Faker(new Locale("de"));

    private static String[] flavours = {"verschenken", "Dienstleistung", "verleihen"};

    public static User getFakeUser() {
        User u = new User();
        u.setLastName(faker.name().lastName());
        u.setFirstName(faker.name().firstName());
        u.setHashedPw(faker.internet().password());
        u.setSessionId(faker.beer().yeast());
        u.setMail(faker.internet().emailAddress(u.getFirstName()+"."+u.getLastName()));
        u.setPhone(faker.phoneNumber().cellPhone());
        return u;
    }

    private static Post getFakePost(long uid) {
        Post p = new Post();
        p.setUid(uid);
        p.setFlavour(flavours[new Random().nextInt(3)]);
        //p.setCategory(); //TODO
        p.setDescription(faker.lorem().paragraph());
        p.setPostName(faker.lorem().word());
        return p;
    }

    public static Post getFakeOffer(long uid) {
        Post p = getFakePost(uid);
        p.setType("offer");
        return p;
    }

    public static Post getFakeRequest(long uid) {
        Post p = getFakePost(uid);
        p.setType("request");
        return p;
    }

}
