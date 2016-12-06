package com.vnv.Model;

import com.github.javafaker.Faker;
import com.vnv.Dao.FakeImpl.FakeUserDaoImp;
import com.vnv.Dao.FakeImpl.FakeUserRelDaoImpl;
import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.Category;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import org.springframework.context.annotation.Profile;

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
        u.setPassword(faker.internet().password());
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

    @Profile("debug")
    public void makeFakeDbEntries(int number) {
        UserRelDao userRelDao = new FakeUserRelDaoImpl();
        UserDao userDao = new FakeUserDaoImp();

        User tester = userDao.getUserByMail("test@test.de");
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
        }
    }

}