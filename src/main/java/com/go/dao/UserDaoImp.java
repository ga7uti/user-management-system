
package com.go.dao;

import java.util.HashMap;
import java.util.Map;

import com.go.bean.User;

/**
 * @author gauti
 *
 */
public class UserDaoImp implements UserDao {

	private static Map<String, User> userDb = new HashMap<>();

	public UserDaoImp() {
		super();
		setUserMap();
	}

	/**
	 * Method to set dummy data.It inflates the hashmap collection with the dummy data.
	 */
	public void setUserMap() {
		userDb.put("ga7uti",
				new User("Gautam Mishra", "Admin", "ga7uti", "@Qwerty1234", "7042312883", "gauti783@gmail.com"));

		userDb.put("karan", new User("Karan Bisht", "Sales-Representative", "karan", "@Qwerty1234", "7042312882",
				"karan@gmail.com"));

		userDb.put("akasharyz1", new User("Akash Kumar", "Product Master", "akasharyz1", "@Qwerty1234", "7042312803",
				"akash@gmail.com"));

		userDb.put("amitvikram98", new User("Amit Vikram Tripathi", "Retailer", "amitvikram98", "@Qwerty1234",
				"999952320", "avt@gmail.com"));

		userDb.put("shalbinbenny97", new User("Shalbin Benny", "Sales-Representative", "shalbinbenny97", "@Qwerty1234",
				"7894561230", "shalbin@gmail.com"));
	}

	/**
	 * @param username
	 * @param password
	 * @return 
	 * 
	 * Method to login user.It searches the user in the hashmap collection and returns null in case username doesnot exits
	 * or password is wrong and if user exits and password matched then returns user
	 */
	@Override
	public User login(String username, String password) {
		User user = searchUser(username);
		if (user == null) {
			System.out.println("Username  doesnot exist");
			return null;
		} else if (!user.getPassword().equals(password)) {
			System.out.println("Password does not match");
			return null;
		}

		return user;
	}

	/**
	 * @param User
	 * @return 
	 * 
	 * Method to add new user.It first searches the username in  the collection if it is not present then add the new user 
	 * to collection otherwise returns false.
	 */
	@Override
	public boolean register(User user) {
		if (searchUser(user.getUserId()) == null) {
			userDb.put(user.getUserId(), user);
			return true;
		} else {
			System.out.println("User name already exits");
			return false;
		}

	}

	/**
	 * @param User 
	 * 
	 * Method to logout user.If user passed as arguement is not null and user name exits then it changes the user property 
	 * isLoggedIn to false.
	 */
	@Override
	public void logout(User user) {
		if (user != null && searchUser(user.getUserId()) != null) {
			System.out.println(user.getFullname() + " is successfully logged out");
			userDb.get(user.getUserId()).setLoggedIn(false);
		}
	}

	/**
	 * @param String
	 * @return user
	 * 
	 * Method to search is user exists or not.It checks the username passed as a arguement in the collection an return user if 
	 * it is present otherwise null
	 */
	private User searchUser(String username) {
		if (userDb.containsKey(username)) {
			return userDb.get(username);
		}
		return null;
	}

}
