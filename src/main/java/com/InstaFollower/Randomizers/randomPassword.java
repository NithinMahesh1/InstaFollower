package com.InstaFollower.Randomizers;

import java.util.Random;

public class randomPassword {
    public static String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$%!@$%&*";
        Random r = new Random();
        int randomLength = r.nextInt(17 - 17 + 1) + 17;

        Random random = new Random();
        char[] password = new char[randomLength];
        for (int i = 0; i < randomLength; i++) {
            password[i] = characters.charAt(random.nextInt(characters.length()));
        }

        return new String(password);
    }
}
