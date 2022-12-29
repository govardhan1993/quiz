package com.project.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentData extends SqlConnection implements ProjectQuiz {      //// @ author Govardhan Jadhav and Suraj Bondage
	Connection connection = null;
	PreparedStatement statement = null;

	public void insertData(String firstname, String LastName, String Address, String Email, String password) {  

		try {
			StudentData studentData = new StudentData();     // Object of StudentData Class Created Here
			Connection connection = studentData.connectionTest();  // MySql Database Connection Establish Here
			statement = connection.prepareStatement(
					"insert into studentdata1(first_name,last_name,address,email_id,password)values(?,?,?,?,?)");   // write the query for insert input data into Database
			statement.setString(1, firstname);
			statement.setString(2, LastName);
			statement.setString(3, Address);   // Data will be Set Into Database
			statement.setString(4, Email);
			statement.setString(5, password);

			int exe = statement.executeUpdate();    // Here the Query is Executed
			System.out.println(
					" __________________________________________________________________________________________");
			System.out.println(
					"                            Your Resistretion Is Successfully                              ");
			System.out.println(
					"__________________________________________________________________________________________");
			System.out.println("                 Please Note Down Your User Id And Password For Reference      ");
			System.out.println(
					"                            Your Resistration Id Is >>" + Email + "                          ");   // Here user get his login Cardinal
			System.out.println(
					"                            Your Resistration Password Is>>" + password + "                   ");
			System.out.println(
					"__________________________________________________________________________________________");

			System.out.println();
			System.out.println("Press 1 --> For Login ");   // here user can directly goes to login window
			System.out.println("Press 2 --> For Exit");   // if user dont want to login he is exit here
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			if (input == 1) {
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.getLogin();
			} else if (input == 2) {
				System.out.println("Close The Window For Exit");
			}
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	@Override
	public void getRegistration() {
		System.out.println("                                  ** REGISTRATION FORM **                   ");   // Registration window will open here
		System.out.println("Enter Your First Name >> ");
		Scanner scanner = new Scanner(System.in);         // call the Scanner class for take registration details from user
		String firstName = scanner.next();
		System.out.println("Enter Your Last Name >> ");
		String LastName = scanner.next();
		System.out.println("Enter Your Address >> ");
		String Address = scanner.next();
		System.out.println("Enter Your Email_Id >> ");
		String Email = scanner.next();
		System.out.println("Enter Your Password >> ");
		String password = scanner.next();
		insertData(firstName, LastName, Address, Email, password);    // here we call insertData method of StudentData Class and pass the Input to that method

	}

}
