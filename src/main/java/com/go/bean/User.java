package com.go.bean;

/**
 * @author gauti
 *
 */
public class User {

	private String fullname;
	private String category;
	private String userId;
	private String password;
	private String rePassword;
	private String number;
	private String email;
	private boolean isLoggedIn = false;

	public User() {
		super();
	}
	

	
	public User(String fullname, String category, String userId, String password, String number,
			String email) {
		super();
		this.fullname = fullname;
		this.category = category;
		this.userId = userId;
		this.password = password;
		this.number = number;
		this.email = email;
	}



	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRePassword() {
		return rePassword;
	}



	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "[ Fullname : " + fullname + " Category : " + category + " Email : " + email + " Phone No : " + number
				+ " ]";
	}

}
