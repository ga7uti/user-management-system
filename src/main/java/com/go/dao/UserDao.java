package com.go.dao;

import com.go.bean.User;


/**
 * @author gauti
 *
 */
public interface UserDao {

	User login(String username, String password);

	boolean register(User user);

	void logout(User user);
}
