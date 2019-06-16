package com.dentalhygienistschedule.domain;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPreferredHygienist(String preferredHygienist) {
		this.preferredHygienist = preferredHygienist;
	}
	public void setCurrentDentalOffice(String currentDentalOffice) {
		this.currentDentalOffice = currentDentalOffice;
	}

	//Getters
	public String getUserName() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getPreferredHygienist() {
		return preferredHygienist;
	}
	public String getCurrentDentalOffice() {
		return currentDentalOffice;
	}

	//Methods
	public boolean doesUserNameExist(String username) {
		//1. check directory
		//2. loop thru each item and see if it has the file with our user's name
		//3. if it does not exist, we can allow the user to use this name
		//4. Else if it does exist, we have to prompt them to pick a new username	
		File dirPath = new File("/Users/desmond/git/DentalScheduleSystem/DentalScheduleSystem");
		File[] files = dirPath.listFiles();
		
		for(File name : files) {
			if(!name.isDirectory() && name.toString().endsWith(".txt")) {
				if(name.getName().contentEquals(username + ".txt")) {
					return true;
				}
			}	
		}
		return false;
	}
	
	public void createUserAcct() {
		//1. We have all the information available in our private attributes
		//2. Create a new file using the username
		//3. Open the newly created file
		//4. Write to the file our email, address, preferred hygienist, and current dental office on each line
		//5. End it with a '-'
		//6. We will append this file with current appointments AND past appointments
	}
	
}
