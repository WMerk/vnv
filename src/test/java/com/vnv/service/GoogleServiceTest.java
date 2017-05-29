package com.vnv.service;

import com.vnv.Main;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public class GoogleServiceTest {

    @Autowired
    GoogleService googleService;

    @Value("${social.google.client_id}")
    private String client_id;


    @Test
    public void getConfig() {
        JSONObject json = googleService.getConfig();
        assertTrue(json.has("iss"));
        assertEquals(json.getString("clientId"), client_id);
        assertTrue(json.has("auth_endpoint"));
        assertTrue(json.has("response_type"));
        assertTrue(json.has("scope"));
        assertTrue(json.has("redirect_uri"));
        assertTrue(json.has("display"));
    }
}
