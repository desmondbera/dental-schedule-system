package com.dentalhygienistschedule.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Appointments {
	
	public enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	public enum Months {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	}
	
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
		
		//1. Open file using name
		//2. Check if there are any appointments
		//3. Appointments will be after '-'
		
		File fileReader = new File(userName + ".txt");
		try {
			Scanner fileScan = new Scanner(fileReader);
			//Skip the users info.
			for(int x = 0; x < 6; x++) {
				fileScan.nextLine();
			}
			
			//Check if there is another line, if so then we have some appointments
			if(fileScan.hasNextLine()) {
				System.out.println("Found an appointment");
			} else {
				System.out.println("No appointment scheduled.");
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
 	}
	
	//Add an appointment to .txt file
	public void addAppointment() {
		
	}
	
	
}
