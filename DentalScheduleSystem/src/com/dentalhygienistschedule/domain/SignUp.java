package com.dentalhygienistschedule.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SignUp {
	private String username;
	private String password;
	private String passwordConfirm;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	public String getPassword() {
		return password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
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
		try {
			PrintWriter writer = new PrintWriter(username + ".txt");
			writer.write(username + "\n");
			// **DO NOT STORE REAL PASSWORDS LIKE THIS**
			writer.write(password + "\n");
			writer.write(email + "\n");
			writer.write(preferredHygienist + "\n");
			writer.write(currentDentalOffice + "\n");
			writer.write("-");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("You've successfully created an account with us!");
	}
	
	public boolean doPasswordsMatch() {
		System.out.println("Checking if password match...");
		
		if(!password.contentEquals(passwordConfirm)) {
			return false;
		}
		return true;
	}
	
}
