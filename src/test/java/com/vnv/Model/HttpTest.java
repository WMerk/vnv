package com.vnv.Model;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class HttpTest {

    @Test
    public void get() {
        try {
            Http.get("https://google.com");
        } catch (IOException e) {
            fail("IOException");
        }
    }
}
