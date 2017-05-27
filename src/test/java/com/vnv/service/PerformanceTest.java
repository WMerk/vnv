package com.vnv.service;

import com.vnv.dao.UserDao;
import com.vnv.dao.UserRelDao;
import com.vnv.entity.User;
import com.vnv.model.Fake;
import com.vnv.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class PerformanceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRelDao userRelDao;

    @Autowired
    UserDao userDao;

    User theUser;// = userDao.getUserById(1);

    @Before
    public void setUp() throws Exception {
        theUser = Fake.getFakeUser();
        userService.registerUser(theUser);
        System.out.println(theUser);
        for (int i=0; i<50; i++) {
            User user = Fake.getFakeUser();
            userService.registerUser(user);
            if (i%4==0)
                userRelDao.addFriend(theUser, user);
            if (i%4==1)
                userRelDao.addRequest(theUser, user);
            if (i%4==2)
                userRelDao.addRequest(user, theUser);
        }
    }

    @Test
    public void getUser() throws Exception {
        //User theUser = userDao.getUserById(2);
        System.out.println(theUser.toJSON());
        userService.loginUser(theUser.getMail(), theUser.getPassword(), theUser.getSessionId());
        System.out.println(userService.getAllUser(theUser.getUid(), theUser.getSessionId()));
    }

    @After
    public void tearDown() throws Exception {


    }
}
