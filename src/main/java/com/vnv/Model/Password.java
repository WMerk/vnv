package com.vnv.Model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public final class Password {

    private static SecureRandom random = new SecureRandom();
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 512;

    /**
     * generates a random hexadecimal formatted Salt
     * @return Salt
     */
    private static String generateSalt() {
        byte bytes[] = new byte[64];
        random.nextBytes(bytes);
        return String.format("%x", new BigInteger(bytes));
    }

    /**
     * hashes the given password with a newly generated salt
     * @param password  a password
     * @return String[] with hashedPassword Salt
     */
    public static String[] hashPassword(String password) {
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        return new String[] {hashedPassword, salt };
    }

    /**
     * hashes the given password with the given salt
     * @param password  a password
     * @param salt      the appropriate salt
     * @return hashedPassword as String or null if an error occurs
     */
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

    /**
     * checks if a given password matches to a hashed password
     * when hashing with the given salt
     * @param password          the plain password
     * @param salt              the appropriate salt for hashing
     * @param hashedPassword    the hashed password
     * @return true if password matches false if not
     */
    public static Boolean checkPassword(String password, String salt, String hashedPassword) {
        return slowEquals(hashPassword(password, salt).getBytes(), hashedPassword.getBytes());
    }

    /**
     * compares byte[] without breaking at the first wrong byte
     * @param a a byte[]
     * @param b a byte[]
     * @return true if a and b are the same, false if not
     */
    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }


}
