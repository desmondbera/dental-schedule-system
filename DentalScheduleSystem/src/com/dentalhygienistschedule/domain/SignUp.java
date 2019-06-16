package com.dentalhygienistschedule.domain;

public class SignUp {
	private String username;
	private String email;
	private String address;
	private String preferredHygienist;
	private String currentDentalOffice;
	
	//Constructor 1
	public SignUp(String username, String email, String address, String preferredHygienist, String currentDentalOffice) {
		this.username = username;
		this.email = email;
		this.address = address;
		this.preferredHygienist = preferredHygienist;
		this.currentDentalOffice = currentDentalOffice;
	}
	
	//Constructor 2
	public SignUp(String username) {
		this.username = username;
	}
	
	//Setters
	public void setUserName(String username) {
		this.username = username;
	}

	//Getters
	public String getUserName() {
		return username;
	}

	//Methods
	public boolean doesUserNameExist(String username) {
		return false;
		
		//1. check directory
		//2. loop thru each item and see if it has the file with our user's name
		//3. if it does not exist, we can allow the user to use this name
		//4. Else if it does exist, we have to prompt them to pick a new username
		
	}
	
}
