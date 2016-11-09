package com.vnv.Model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public final class Password {

    private static SecureRandom random = new SecureRandom();
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;

    private static String generateSalt() {
        byte bytes[] = new byte[64];
        random.nextBytes(bytes);
        return String.format("%x", new BigInteger(bytes));
    }

    public static String[] hashPassword(String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        return new String[] {hashedPassword, salt };
    }

    private static String hashPassword(String password, String salt) {
        char[] passwordChars = password.toCharArray();
        PBEKeySpec spec = new PBEKeySpec(passwordChars, salt.getBytes(), ITERATIONS, KEY_LENGTH);
        try {
            SecretKeyFactory key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashedPassword = key.generateSecret(spec).getEncoded();
            return String.format("%x", new BigInteger(hashedPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Boolean checkPassword(String password, String salt, String hashedPassword) {
        return slowEquals(hashPassword(password, salt).getBytes(), hashedPassword.getBytes());
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }


}
