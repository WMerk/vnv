package com.vnv.service;

import com.vnv.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class MessageServiceTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void name() throws Exception {


    }

    @After
    public void tearDown() throws Exception {

    }

}