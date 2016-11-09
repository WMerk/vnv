package test;

import com.vnv.Model.Password;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gabriel on 04.11.2016.
 */
public class PasswordTest {
    @Test
    public void checkPassword() throws Exception {
        String[] hashedpw = Password.hashPassword("password");
        assertTrue(Password.checkPassword("password", hashedpw[1], hashedpw[0]));
        assertFalse(Password.checkPassword("Password", hashedpw[1], hashedpw[0]));
    }

}