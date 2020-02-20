package com.go.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.go.bean.User;

/**
 * @author gauti
 *
 */
public class ValidateUtil {
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 * 
	 * Method to validate login details
	 */
	public static boolean loginValidation(String userId, String password) {
		if (validateUserId(userId) && validatePassword(password, "", false)) {
			return true;
		}
		return false;
	}

	
	/**
	 * @param User
	 * @return
	 * 
	 * Method to validate registration details
	 */
	public static boolean registerValidation(User user) {
		if (validateUserId(user.getUserId()) && validatePassword(user.getPassword(), user.getRePassword(), true)
				&& validateEmail(user.getEmail()) && validatePhone(user.getNumber())) {
			return true;
		}
		return false;
	}

	/**
	 * @param String
	 * @return
	 * 
	 * Method to validate email using regular expression
	 */
	private static boolean validateEmail(String email) {
	    String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		if (email.isEmpty()) {
			System.out.println("Email cannot be blank");
			return false;
		} else if (!matcher.matches()) {
			System.out.println("Please enter a valid email");
			return false;
		}
		return true;
	}

	/**
	 * @param String
	 * @return
	 * 
	 * Method to validate phone number

	 */
	private static boolean validatePhone(String phone) {
		if (phone.isEmpty()) {
			System.out.println("Phone number cannot be blank");
			return false;
		} else if (phone.length() != 10 || !phone.matches("^[1-9]\\d*$")) {
			System.out.println("Please enter a valid number");
			return false;
		}
		return true;
	}

	/**
	 * @param String
	 * @return
	 * 
	 * Method to validate user id 
	 */
	private static boolean validateUserId(String userId) {
		if (userId.isEmpty()) {
			//System.out.println("UserId cannot be blank");
			return false;
		} else if (!userId.matches("[A-Za-z0-9]+")) {
			//System.out.println("UserId must be alphanumeric");
			return false;
		}

		return true;
	}

	/**
	 * @param String
	 * @param String
	 * @param boolean
	 * @return
	 * 
	 * Method to validate password
	 */
	private static boolean validatePassword(String password, String rePassword, boolean isRegister) {
		if (password.isEmpty()) {
			System.out.println("Password cannot be empty");
			return false;
		} else if (password.length() < 8) {
			System.out.println("Password must contain atleast 8 characters");
			return false;
		} else if (!password.matches(".*[A-Z].*")) {
			System.out.println("Password must contain atleast 1 uppercase characters");
			return false;
		} else if (!password.matches(".*[a-z].*")) {
			System.out.println("Password must contain atleast 1 lowercase characters");
			return false;
		} else if (!password.matches(".*\\d.*")) {
			System.out.println("Password must contain atleast 1 digit");
			return false;
		} else if (!password.matches(".*[`~!@#$%^&*()\\\\-_=+\\\\\\\\|\\\\[{\\\\]};:'\\\",<.>/?].*")) {
			System.out.println("Password must contain atleast 1 special characters");
			return false;
		} else if (isRegister && !password.equals(rePassword)) {
			System.out.println("Password doesnot match");
			return false;
		}
		return true;
	}
}
