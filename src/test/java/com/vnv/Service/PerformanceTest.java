package com.vnv.Service;

import com.vnv.Dao.UserDao;
import com.vnv.Dao.UserRelDao;
import com.vnv.Entity.User;
import com.vnv.Main;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class PerformanceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRelDao userRelDao;

    @Autowired
    UserDao userDao;

 //   User theUser = userDao.getUserById(1);
/*
    @Before
    public void setUp() throws Exception {
        theUser = Fake.getFakeUser();
        userService.registerUser(theUser);
        for (int i=0; i<250; i++) {
            User user = Fake.getFakeUser();
            userService.registerUser(user);
            if (i%3==0)
                userRelDao.addFriend(theUser, user);
        }
    }
*/
    @Test
    public void getUser() throws Exception {
        User theUser = userDao.getUserById(1);
        System.out.println(theUser.toJSON());
        userService.loginUser(theUser.getMail(), theUser.getPassword(), theUser.getSessionId());
        System.out.println(userService.getAllUser(1, theUser.getSessionId()));
    }

    @After
    public void tearDown() throws Exception {


    }
}
