package com.example.videorental.utilities;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Random;

public class Utility <T>{

    public static boolean isValidInput(String input){
        return input != null && !input.isEmpty();
    }

    public static boolean isValidInput(Object input){
        return input != null;
    }

    public static boolean isValidInput(int input){
        return input != 0;
    }

    public static boolean isValidInput(double input){
        return input > 0;
    }

    public static boolean isValidEmail(String email){
        return EmailValidator.getInstance(true).isValid(email);
    }


    public static String generateRandomString(int length) {
        Random random = new Random();
        return random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
