package com.project.quiz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Individualresult extends SqlConnection {    // @ author Govardhan Jadhav and Kajal Juwar

	public void getLoginDetails(String userName) {   // take input from user check it with condition..

		try {
			LoginDetails loginDetails = new LoginDetails();
			connection = loginDetails.connectionTest();
			PreparedStatement statement = connection.prepareStatement("select * from studentdata1 ");  // here we take fetch data from database
			ResultSet values = statement.executeQuery();  // query executed 
			System.out.println();

			System.out.println("                               Your Result Is Below \n");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.printf("|  %-20s|  %-20s|  %-20s|  %-20s|  %-8s|  %-9s|", "First Name", "Last Name", "Address", "Email_id", "Marks","Grade");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			while (values.next()) {
				String s = values.getString("email_id");      // here we check if entered user id is match with database then that user result will display here 
				if (s.equals(userName)) {
					userName = s;
					String fname = values.getString(2);
					String lname = values.getString(3);
					String address = values.getString(4);
					String emailid = values.getString(5);
					String marks = values.getString(7);
					String grade = values.getString(8);
					System.out.println();
					System.out.printf("|  %-20s|  %-20s|  %-20s|  %-20s|  %-8s|  %-9s|", fname, lname, address, emailid, marks,grade);
					System.out.println();
					System.out.println("--------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					
					if(grade.equals("A"))
					{
						System.err.printf("%-50s","Congratulation Your Are Pass And Your Grade is A");
					}
					else if(grade.equals("B"))
					{
						System.err.printf("%-50s","Congratulation Your Are Pass And Your Grade is B ");    // here we give some meaningful message to user
					}
					else if(grade.equals("C"))
					{
						System.err.printf("%-50s","Congratulation Your Are Pass And Your Grade is C");
					}
					else {
						System.err.printf("%-50s","Fail ..! Better Luck Next Time");
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getLogin() {
		System.out.println();
		System.out.println("Enter Your User ID For Get Your Result");   // it take the input from user and pass this input to getLoginDetails Method
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		getLoginDetails(userName);
		return userName;

	}
	
}