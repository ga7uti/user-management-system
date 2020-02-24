package com.go.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.go.bean.User;

public class UserDaoImplementationTest {
	
	private static Map<String, User> userDb = new HashMap<>();

	@BeforeAll
	static void setup() {
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
	
	@Test
	void testRegister() {
		assertTrue(new UserDaoImp().register(new User("Gautam Mishra", "Admin", "gauti", "@Qwerty1234", "7042312883", "gauti783@gmail.com")));
		assertFalse(new UserDaoImp().register(new User("Gautam Mishra", "Admin", "ga7uti", "@Qwerty1234", "7042312883", "gauti783@gmail.com")));
	}
}
