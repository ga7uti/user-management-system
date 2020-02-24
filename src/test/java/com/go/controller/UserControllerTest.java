package com.go.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.go.bean.User;

public class UserControllerTest {
	
	
	@Test
	void testRegister() {
		assertTrue(new UserController().register(new User("Gautam Mishra", "Admin", "gauti", "@Qwerty1234", "7042312883", "gauti783@gmail.com")));
		assertFalse(new UserController().register(new User("Gautam Mishra", "Admin", "gauti", "@qwerty1234", "7042312883", "gauti783@gmail.com")));
	}

}
