package com.project.quiz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MarksUser extends SqlConnection {   // // @ author Kajal Juwar and Suraj Bondage
	public void getLoginDetails(String userName) {

		try {
			LoginDetails loginDetails = new LoginDetails();
			connection = loginDetails.connectionTest();
			PreparedStatement statement = connection.prepareStatement("select * from studentdata1 ");   // Establish connection to database write the query for select all data from database
			ResultSet values = statement.executeQuery();  // here query will executed
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getLogin() {   // this method is use for store the data to that particular user rows only
		System.out.println("\n");
		System.out.println("Enter Your User Id To Submit Exam ..!");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		getLoginDetails(userName);
		return userName;
		
	}

}
