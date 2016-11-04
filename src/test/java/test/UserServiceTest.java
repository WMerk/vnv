package test;

import com.vnv.Controller.Password;
import com.vnv.Entity.User;
import com.vnv.Main;
import com.vnv.Service.UserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class UserServiceTest {

    @Autowired
    UserService us;

    @Test
    public void registerUser() throws Exception {

        JSONObject testUser = new JSONObject();
        testUser.put("mail", "test.user@test.com");
        testUser.put("firstName", "test");
        testUser.put("lastName", "user");
        testUser.put("password", "pass");
        assertTrue(us.registerUser(testUser));
    }


}