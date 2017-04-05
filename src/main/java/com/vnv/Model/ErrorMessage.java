package com.vnv.Model;

public class ErrorMessage {

    private static String Error = "{\"error\":\"%s\", \"status\":\"%d\"}";

    public static String DefaultError = String.format(Error, "an error occurred", 500);

    public static String NotLoggedIn = String.format(Error, "not logged in", 401);
    public static String AlreadyLoggedOut = String.format(Error, "already logged out", 200);
    public static String WrongMailPassword = String.format(Error, "wrong mail or password", 401);
    public static String WrongPassword = String.format(Error, "wrong password", 401);
    public static String AlreadyRegistered = String.format(Error, "mail already registered", 409);

    public static String NotImplemented = String.format(Error, "not implemented", 500);

    public static String NoCategoriesAvailable = String.format(Error, "no categories available", 404);
    public static String NoCategory = String.format(Error, "the given category is not a category", 400);

    public static String getError(String error, int status) {
        return String.format(Error, error, status);
    }
}
