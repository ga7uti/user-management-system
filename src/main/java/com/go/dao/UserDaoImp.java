	
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
	 * Method to set dummy data
	 */
	public void setUserMap() {
		userDb.put("ga7uti",
				new User("Gautam Mishra", "Admin", "ga7uti", "@Qwerty1234", "7042312883", "gauti783@gmail.com"));

		userDb.put("karan", new User("Karan Bisht", "Sales-Representative", "karan", "@Qwerty1234", "7042312882",
				"karan@gmail.com"));

		userDb.put("akasharyz1",
				new User("Akash Kumar", "Product Master", "akasharyz1", "@Qwerty1234", "7042312803", "akash@gmail.com"));

		userDb.put("amitvikram98", new User("Amit Vikram Tripathi", "Retailer", "amitvikram98", "@Qwerty1234",
				"999952320", "avt@gmail.com"));

		userDb.put("shalbinbenny97", new User("Shalbin Benny", "Sales-Representative", "shalbinbenny97", "@Qwerty1234",
				"7894561230", "shalbin@gmail.com"));
	}

	
	/**
	 * @param String,String
	 * @return
	 * Method to login user
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
	 * Method to put new user
	 */
	@Override
	public boolean register(User user) {
		if(searchUser(user.getUserId()) == null) {
			userDb.put(user.getUserId(), user);
			return true;
		}else {
			System.out.println("User name already exits");
			return false;
		}
		
	}

	
	
	/**
	 * @param User
	 * Method to logout user
	 */
	@Override
	public void logout(User user) {
		if (user != null) {

			if (searchUser(user.getUserId()) != null) {
				System.out.println(user.getFullname() + " is successfully logged out");
				userDb.get(user.getUserId()).setLoggedIn(false);
			}
		}
	}

	
	
	/**
	 * @param String
	 * @return
	 * 
	 * Method to search is user exists or not
	 */
	private User searchUser(String username) {
		if (userDb.containsKey(username)) {
			return userDb.get(username);
		}
		return null;
	}

}
