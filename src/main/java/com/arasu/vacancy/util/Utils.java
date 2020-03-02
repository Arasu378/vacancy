package com.arasu.vacancy.util;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static SecureRandom random = new SecureRandom();
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    // optional, make it more random
    private static final String PASSWORD_ALLOW_BASE_SHUFFLE = shuffleString(PASSWORD_ALLOW_BASE);
    private static final String PASSWORD_ALLOW = PASSWORD_ALLOW_BASE_SHUFFLE;
	public static String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public static boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			System.out.println("The password matches.");
			return true;
		}
			System.out.println("The password does not match.");
			return false;
	}
	 public static String generateRandomPassword(int length) {
	        if (length < 1) throw new IllegalArgumentException();

	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {

	            int rndCharAt = random.nextInt(PASSWORD_ALLOW.length());
	            char rndChar = PASSWORD_ALLOW.charAt(rndCharAt);

	            // debug
	            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

	            sb.append(rndChar);

	        }

	        return sb.toString();

	    }

	 	public static String shuffleString(String string) {
	        List<String> letters = Arrays.asList(string.split(""));
	        Collections.shuffle(letters);
	        return letters.stream().collect(Collectors.joining());
	    }
	 	
	 	public static Date dateFormatter(String date) {
	 		DateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
	 		Date myDate = null;
	 		try {
				 myDate = formatter.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	 		return myDate;
	 	}
	 	public static Date currentDate() {
			return new Date();
		}
}
