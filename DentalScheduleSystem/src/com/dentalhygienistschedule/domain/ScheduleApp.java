package com.dentalhygienistschedule.domain;
import java.util.Scanner;

public class ScheduleApp {

	private static boolean booleanFlag = false;
	private static Scanner scan = new Scanner(System.in);
	private static Login userLogin;
	private static SignUp userSignup;

	public static void main(String[] args) {
		System.out.println("Starting Dental Scheduling App...");

		// 1. Once a patient lands on the page they will have 2 options
		// 1.1 - LOG IN
		// 1.2 - SIGN UP
		System.out.println("==============");
		System.out.println("Welcome. Do you want to login or sign up?");

		while (!booleanFlag) {
			String userInput = scan.nextLine();
			System.out.println("You chose " + userInput);

			if (userInput.equalsIgnoreCase("login")) {
				booleanFlag = true;
				// 1. Ask user for username, password, and confirm password
				initiateLogIn();

			} else if (userInput.equalsIgnoreCase("sign up")) {
				booleanFlag = true;
				// 1. Ask user to fill sign up form
				initiateSignUp();
			} else {
				System.out.println("You need to type a valid input");
			}
		}

		// 2. If the user is already signed up (in our DB) we will show the following
		// options once they log in:
		// 2.1 - Show appointments they made
		// 2.2 - Show a list of hygienist's they can choose from OR search functionality
		// 2.3 - Schedule an appointment
		// 2.4 - Cancel an appointment

		// 3. If the user is signing up we will show the following options:
		// 3.1 - Enter name
		// 3.2 - Enter email
		// 3.3 - Enter Address
		// 3.4 - Preferred Hygienist Name
		// 3.5 - Dental Office they frequent
	}

	private static void initiateLogIn() {
		System.out.println("Initiating loggging in....");

		boolean passwordMatch = false;
		while (!passwordMatch) {
			String userName;
			String password;
			String confirmPassword;

			System.out.println("Enter username: ");
			userName = scan.nextLine();

			System.out.println("Enter password: ");
			password = scan.nextLine();

			System.out.println("Confirm password: ");
			confirmPassword = scan.nextLine();

			userLogin = new Login(userName, password, confirmPassword);

			if (userLogin.doPasswordsMatch()) {
				System.out.println("Welcome " + userLogin.getUsername());

				passwordMatch = true;
				boolean isOptionValid = false;
				while (!isOptionValid) {
					userLogin.displayLoginOptions();
					int loginOption = scan.nextInt();

					switch (loginOption) {
					case 1:
						System.out.println("Showing appointments..");
						Appointments appt = new Appointments();
						appt.checkAppointments(userName);
						isOptionValid = true;
						break;
					case 2:
						System.out.println("Showing list of hygienists..");
						isOptionValid = true;
						break;
					case 3:
						System.out.println("When did you want to schedule appointment?");
						isOptionValid = true;
						break;
					case 4:
						System.out.println("Are you sure you want to cancel your appt?");
						isOptionValid = true;
						break;
					default:
						System.out.println("That's not a valid option. Try again.\n");
						break;
					}
				}

			} else {
				System.out.println("Your passwords do not match.");
			}
		}

	}

	private static void initiateSignUp() {
		System.out.println("Initiating sign up....");
		boolean userNameTaken = true;
		while(userNameTaken) {
			String name;
			String email;
			String address;
			String preferredHygienist;
			String currentDentalOffice;
			
			System.out.println("Enter a new username: ");
			name = scan.nextLine();
			
			userSignup = new SignUp(name);
			if(!userSignup.doesUserNameExist(userSignup.getUserName())) {
				userNameTaken = false;
				
				System.out.println("Enter your e-mail: ");
				email = scan.nextLine();
				userSignup.setEmail(email);
				
				System.out.println("Enter your address: ");
				address = scan.nextLine();
				userSignup.setAddress(address);
				
				System.out.println("Enter the name of your preferred hygienist: ");
				preferredHygienist = scan.nextLine();
				userSignup.setPreferredHygienist(preferredHygienist);
				
				System.out.println("Enter the name of your current dental office: ");
				currentDentalOffice = scan.nextLine();
				userSignup.setCurrentDentalOffice(currentDentalOffice);
				
				userSignup.createUserAcct();
				
			} else {
				System.out.println("Username already exists. Pick a new one.");
			}
			
			
//			userSignup = new SignUp(name, email, address, preferredHygienist, currentDentalOffice);
			
//			if(userSignup.doesUserNameExist()) {
//				System.out.println("Username already exists");
//			} else {
//				System.out.println("Username does not exist.");
//				userNameTaken = false;
//				
//				
//			}
		}
	}
	
	

}
