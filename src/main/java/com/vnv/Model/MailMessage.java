package com.vnv.Model;

public class MailMessage {

    private final static String gwelcome = "Hi %s,<br>" +
            "<br>" +
            "willkommen zu vnv. Wir freuen uns, dass du dich mit deinem google Konto bei vnv registriert hast.<br>" +
            "<br>" +
            "Schoene Gruesse<br>" +
            "Dein vnv-team";

    public static String getGwelcome(String name) {
        return String.format(gwelcome, name);
    }
}
