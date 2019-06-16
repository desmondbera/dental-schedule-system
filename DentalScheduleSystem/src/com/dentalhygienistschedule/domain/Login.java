package com.dentalhygienistschedule.domain;

import com.dentalhygienistschedule.utils.DentalHygienists;

public class Login implements DentalHygienists {

	private String username;
	private String password;
	private String confirmPassword;
	
	// Constructor
	public Login(String username, String password, String confirmPassword) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	//Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//Getters
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	//Methods
	public boolean doPasswordsMatch() {
		System.out.println("Checking if password match...");
		
		if(!password.contentEquals(confirmPassword)) {
			return false;
		}
		return true;
	}
	
	public void displayLoginOptions() {
		System.out.printf("Enter '1' to show your appointments\n" 
				+ "Enter '2' to show a list of hygienists\n" 
				+ "Enter '3' to schedule an appointment\n" 
				+ "Enter '4' to cancel an appointment\n");
	}
	
//	public 
	
}
