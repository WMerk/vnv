package com.vnv.model;

import com.github.javafaker.Faker;
import com.vnv.dao.CategoryDao;
import com.vnv.dao.PostDao;
import com.vnv.dao.UserDao;
import com.vnv.dao.UserRelDao;
import com.vnv.dao.fake.FakeCategoryDaoImpl;
import com.vnv.dao.fake.FakePostDaoImpl;
import com.vnv.dao.fake.FakeUserDaoImp;
import com.vnv.dao.fake.FakeUserRelDaoImpl;
import com.vnv.dao.impl.RedisCategoryDaoImpl;
import com.vnv.entity.Post;
import com.vnv.entity.User;
import org.springframework.context.annotation.Profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fake {

    private static final Faker FAKER = new Faker(new Locale("de"));

    private static String[] flavours = {"verschenken", "Dienstleistung", "verleihen"};
    private static String[] status = {"Verfügbar", "Reserviert", "Beendet"};
    private static Random random = new Random();

    private static CategoryDao categoryDao = new FakeCategoryDaoImpl();

    public static Faker getFAKER() {
        return FAKER;
    }



    public static User getFakeUser() {
        User u = new User();
        u.setLastName(FAKER.name().lastName());
        u.setFirstName(FAKER.name().firstName());
        u.setName(u.getFirstName()+" "+u.getLastName());
        u.setPassword(FAKER.internet().password());
        u.setSessionId(FAKER.internet().password(25,26,true,true));
        u.setMail(FAKER.internet().emailAddress(u.getFirstName()+"."+u.getLastName()));
        u.setPhone(FAKER.phoneNumber().cellPhone());
        return u;
    }

    private static DateFormat outputDF = new SimpleDateFormat("d.MM.yyyy");
    private static Post getFakePost(User user) {
        if (Profiles.checkProdActive())
            categoryDao = new RedisCategoryDaoImpl();
        Post p = new Post();
        p.setUser(user);
        p.setFlavour(flavours[random.nextInt(3)]);
        p.setCategory(random(categoryDao.getAllCategories()));
        p.setDescription(FAKER.lorem().paragraph());
        p.setPostName(FAKER.lorem().word());
        p.setType(random.nextBoolean() ? "offer" : "request");
        p.setStatus(status[random.nextInt(3)]);
        p.setPeriod(outputDF.format(FAKER.date().future(Math.abs(random.nextInt()), TimeUnit.SECONDS, new Date())));
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

    @Profile("debug")
    public void makeFakeDbEntries(int number) {
        UserRelDao userRelDao = new FakeUserRelDaoImpl();
        UserDao userDao = new FakeUserDaoImp();
        PostDao postDao = new FakePostDaoImpl();

        User tester = userDao.getUserByMail("test@test.de");
        for (int j=0; j<5; j++) {
            Post post = Fake.getFakePost(tester);
            postDao.insertPost(post);
        }
        for (int i=0; i<number; i++) {
            User u = getFakeUser();
            userDao.insertUserToDb(u);
            userRelDao.addUser(u);
            if (random.nextBoolean()) {
                // a random relationship will be inserted
                int rand = random.nextInt(4);
                if (rand==1)
                    userRelDao.addFriend(u, tester);
                if (rand==2)
                    userRelDao.addRequest(u, tester);
                if (rand==3)
                    userRelDao.addRequest(tester, u);
            }
            u = userDao.getUserByMail(u.getMail());
            for (int j=0; j<3; j++) {
                Post post = Fake.getFakePost(u);
                postDao.insertPost(post);
            }
        }
    }


    private static <T> T random(Collection<T> coll) {
        int num = (int) (Math.random() * coll.size());
        for(T t: coll) if (--num < 0) return t;
        throw new AssertionError();
    }

}
