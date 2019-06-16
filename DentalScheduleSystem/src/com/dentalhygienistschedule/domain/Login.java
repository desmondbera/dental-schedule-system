package com.dentalhygienistschedule.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.dentalhygienistschedule.utils.DentalHygienists;

public class Login implements DentalHygienists {

	private String username;
	private String password;
	
	// Constructor
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//Setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Getters
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	//Methods
	public boolean doPasswordsMatch() {
		//1. open the file using the username
		//2. check the second line for the password
		//3. compare it with the current password in our private attribute
		
		File fileReader = new File(username + ".txt");
		Scanner fileScan;
		try {
			fileScan = new Scanner(fileReader);
			//SKIPPING FIRST LINE IN OUR .TXT FILE
			for(int x = 0; x < 1; x++) {
				fileScan.nextLine();
			}
			// We are at the 2nd line, which has our password from when the user signed up.
			if(fileScan.nextLine().contentEquals(password)) {
				fileScan.close();
				return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean doesUserExist() {
		//1. loop thru the directory where all the files live
		//2. if a .txt file with our username exists then our user also exists
		File dirPath = new File("/Users/desmond/git/DentalScheduleSystem/DentalScheduleSystem");
		File[] files = dirPath.listFiles();
		
		for(File name : files) {
			if(!name.isDirectory() && name.toString().endsWith(username + ".txt")) {
				return true;
			}
		}
		return false; 
	}
	
	public void displayLoginOptions() {
		System.out.printf("\n"
				+ "=============================\n"
				+ "Enter '1' to show your appointments\n" 
				+ "Enter '2' to show a list of hygienists\n" 
				+ "Enter '3' to schedule an appointment\n" 
				+ "Enter '4' to cancel an appointment\n" 
				+ "Enter '5' to exit program\n"
				+ "=============================\n" 
				+ "\n");
	}
	
	
	
}
