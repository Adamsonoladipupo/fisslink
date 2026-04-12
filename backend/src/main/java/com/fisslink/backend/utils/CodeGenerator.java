package com.fisslink.backend.utils;
import java.security.SecureRandom;

public class CodeGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 5;
    private static final SecureRandom random = new SecureRandom();

    public static String generate() {
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int generate = 0; generate < LENGTH; generate++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
