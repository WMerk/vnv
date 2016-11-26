package com.vnv;

import com.github.javafaker.Faker;
import com.vnv.Entity.Category;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;

import java.util.Locale;
import java.util.Random;

public class Fake {

    public static Faker faker = new Faker(new Locale("de"));

    private static String[] flavours = {"verschenken", "Dienstleistung", "verleihen"};
    private static Random random = new Random();


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

    private static Post getFakePost(User user) {
        Post p = new Post();
        p.setUser(user);
        p.setFlavour(flavours[random.nextInt(3)]);
        Category c = new Category();
        c.setId(0L);c.setName("TestCategory");
        p.setCategory(c);
        p.setDescription(faker.lorem().paragraph());
        p.setPostName(faker.lorem().word());
        return p;
    }

    public static Post getFakeOffer(User user) {
        Post p = getFakePost(user);
        p.setType("offer");
        return p;
    }

    public static Post getFakeRequest(User user) {
        Post p = getFakePost(user);
        p.setType("request");
        return p;
    }

}
