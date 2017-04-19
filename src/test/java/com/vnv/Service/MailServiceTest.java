package com.vnv.Service;

import com.vnv.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void sendMail() {
        try {
            mailService.sendEmail("web.vnv@gmail.com", "UnitTest", "This is a unittest sent mail.");
        } catch (MessagingException e) {
            fail(e.getMessage());
        }
    }
}
