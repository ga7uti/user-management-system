package com.go.ui;

import java.util.Scanner;

import com.go.bean.User;
import com.go.controller.UserController;

public class Execute {

	private User user = null;
	private Scanner scanner;
	private UserController controller;

	public Execute() {
		super();
		scanner = new Scanner(System.in);
		controller = new UserController();
	}

	/**
	 * User Interface for intreaction with user
	 */
	public void run() {
		boolean runLoop = true;
		String username = "";
		String password = "";
		while (runLoop) {
			System.out.print("User Managment System \n " + "1. Login \n " + "2. Register \n " + "3. Logout \n"
					+ "Enter your  choice : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your user id");
				username = scanner.next();
				System.out.println("Enter your password");
				password = scanner.next();
				user = controller.login(username, password);
				if (user != null) {
					System.out.println("Logged in successfully");
					System.out.println(user);
					user.setLoggedIn(true);
				}
				break;
			case 2:
				user = getUserDetails();
				if (controller.register(user)) {
					System.out.println("Registered successfully You can login now");
				}
				break;

			case 3:

				if (user != null) {
					controller.logout(user);
					user = null;
				} else {
					System.out.println("No user logged in ");
				}
				break;
			default:
				System.out.println("Wrong choice");
			}

			System.out.println("Want to exit y/n ");

			if (scanner.next().equals("y")) {
				runLoop = false;
			}
		}

		scanner.close();

	}

	/**
	 * @return
	 * 
	 *         Method to get details for registration
	 */
	private User getUserDetails() {
		User user = new User();
		System.out.println("Enter your name");
		user.setFullname(scanner.next());
		System.out.println("Enter your user id");
		user.setUserId(scanner.next());
		System.out.println("Enter your password");
		user.setPassword(scanner.next());
		System.out.println("Enter your password again");
		user.setRePassword(scanner.next());
		System.out.println("Enter your role\n 1. Retailer \n 2. Sales-Representative \n Enter choice : ");
		int choice = scanner.nextInt();
		if (choice == 1) {
			user.setCategory("Retailer");
		} else {
			user.setCategory("Sales-Representative");
		}
		System.out.println("Enter your email");
		user.setEmail(scanner.next());
		System.out.println("Enter your phone");
		user.setNumber(scanner.next());
		return user;
	}
}
