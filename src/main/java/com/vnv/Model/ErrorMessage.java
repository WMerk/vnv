package com.vnv.Model;

public class ErrorMessage {

    public static String Error = "{error: %s}";

    public static String DefaultError = String.format(Error, "an error occurred");

    public static String NotLoggedIn = String.format(Error, "not logged in");
    public static String AlreadyLoggedOut = String.format(Error, "already logged out");
    public static String WrongMailPassword = String.format(Error, "wrong mail or password");
    public static String AlreadyRegistered = String.format(Error, "mail already registeredmail already registered");

}
