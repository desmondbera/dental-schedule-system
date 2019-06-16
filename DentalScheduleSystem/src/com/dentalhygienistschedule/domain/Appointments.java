package com.dentalhygienistschedule.domain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Appointments {
	
	private String day;
	private byte month;
	private short year;
	private byte hour;
	private byte min;
	
	//1. We need a data structure to store our appointments
	// for now we can use a .txt file
	//2. We need to loop thru our .txt file and grab our user's appointment information
	
	//Constructor 1
	public Appointments(String day, byte month, short year, byte hour, byte min) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.min = min;
	}
	//Constructor 2
	public Appointments() {}
	
	//Setters
	public void setDay(String day) {
		this.day = day;
	}
	public void setMonth(byte month) {
		this.month = month;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public void setHour(byte hour) {
		this.hour = hour;
	}
	public void setMin(byte min) {
		this.min = min;
	}
	
	//Getters
	public String getDay() {
		return day;
	}
	public byte getMonth() {
		return month;
	}
	public short getYear() {
		return year;
	}
	public byte getHour() {
		return hour;
	}
	public byte getMin() {
		return min;
	}
	
	//Methods
	
	//Check .txt file for appointments
	public void checkAppointments(String userName) {
		
		Path path = Paths.get(userName +".txt");
		boolean userExists = userExists(path);
		if(userExists) {
			System.out.println("Found user!");
		} else {
			System.out.println("You have to create an account before you can check your appoint");
		}
 	}
	
	//Add an appointment to .txt file
	public void addAppointment() {
		
	}
	
	private static boolean userExists(Path filePath) {
		if(Files.exists(filePath)) {
			return true;
		} else {
			return false;
		}
	}
	
}
