package test;

import com.vnv.Database;
import com.vnv.Entity.User;
import com.vnv.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import redis.clients.johm.JOhm;

import static org.junit.Assert.*;

/**
 * Created by Gabriel on 03.11.2016.
 */
@SpringApplicationConfiguration(classes = Main.class)
public class DatabaseTest {

    Database db;
    User testUser = new User();

    @Before
    public void setUp() throws Exception {
        db = new Database();
        testUser.setUid(new Long(-1));
        testUser.setFirstName("test");
        testUser.setLastName("user");
        testUser.setMail("test.user@test.com");
        testUser.setMailValid(true);
        testUser.setPhoneValid(false);
        testUser.setHashedPw("test".getBytes());
        testUser.setSalt("salt".getBytes());
    }

    @After
    public void tearDown() throws Exception {
        JOhm.delete(User.class, -1, true, true);
    }

    @Test
    public void saveUser() throws Exception {
        db.init();
        JOhm.save(testUser);
        User loaded = JOhm.get(User.class, -1);
        assertNotNull(loaded);
        assertEquals(testUser.toString(), loaded.toString());
    }

}