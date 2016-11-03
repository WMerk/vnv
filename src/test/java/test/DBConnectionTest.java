package test;

import com.vnv.Database;
import com.vnv.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Gabriel on 03.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
public class DBConnectionTest {

    @Test
    public void connection() throws Exception{
        Database db = new Database();
        db.init();
    }

}