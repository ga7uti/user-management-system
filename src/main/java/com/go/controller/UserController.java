package com.go.controller;

import com.go.bean.User;
import com.go.dao.UserDao;
import com.go.dao.UserDaoImp;
import com.go.util.ValidateUtil;

public class UserController {

	private UserDao userDao;

	public UserController() {
		super();
		userDao = new UserDaoImp();

	}

	/**
	 * @param username
	 * @param password
	 * @return
	 * 
	 * Method to login user
	 */
	public User login(String username , String password) {
		if(ValidateUtil.loginValidation(username, password) ) {
			return userDao.login(username, password);
		}
		return null;
	}
	
	/**
	 * @param user
	 * @return
	 * 
	 * Method to register user
	 */
	public boolean register(User user) {
		if(ValidateUtil.registerValidation(user)) {
			return userDao.register(user);
		}
		
		return false;
	}
	
	/**
	 * @param user
	 * 
	 * Method to logout user
	 */
	public void logout(User user) {
		if(user != null) {
			userDao.logout(user);
		}
	}
}
