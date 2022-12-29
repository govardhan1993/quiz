package com.project.quiz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class LoginDetails extends SqlConnection implements ProjectQuiz1 { //// @ author Govardhan Jadhav, Suraj Bondage and Kajal Juwar

	public void getLoginDetails(String userName, String password) {     

		try {
			LoginDetails loginDetails = new LoginDetails();    // Object of LoginDetails Class Created here..
			connection = loginDetails.connectionTest();   // Establish Connection of MySql Database // Calling connectionTest Method of SqlConnection class
			PreparedStatement statement = connection.prepareStatement("select * from studentdata1 "); // write query for get Data from Database
			ResultSet values = statement.executeQuery();
			int count = 0;
			while (values.next()) {     
				String s = values.getString("email_id");   // take data of email_id field from database
				String p = values.getString(6);          //   take data of password field from database
				if (s.equals(userName) && p.equals(password)) {    // here we check user details if it match then login will be successful 
					//userName = s; 
				//	password = p;
					count = 1;       // if condition will true then count is increased 
				}
			}
			if (count == 1) {    // if condition will true it will be enter into if block and method quizQuetion of QuizQuestions Class is Called
				System.out.println("\n");
				System.out.println("                                      Login Succesfull                         ");
				System.out.println("Press 1 Start Test..");
				Scanner scanner=new Scanner(System.in);
				int input=scanner.nextInt();
				if(input==1)
				{
					RandomQuetions randomQuetions=new RandomQuetions();  // if login is successful then jvm will go to getQuetions() for display Quetions
					randomQuetions.getQuetions();
				}
				
				
				System.out.println("\n");
				
			} else {
				System.err.println("Please Check Detials");    // it Details is match then error massage will display
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void getLogin() {
		System.out.println("              ** LOGIN **");    // login window will be open here
		System.out.println("Enter Your User Id");     // user enter user id here 
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		System.out.println("Enter Your Password");   // user enter password here
		String password = scanner.next();
		System.out.print("Please Wait ");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(600);
				System.out.print(". ");
			} catch (InterruptedException e) {     
				e.printStackTrace();
			}
		}
		System.out.println();
		getLoginDetails(userName, password);    // pass the input to getLoginDetails method of LoginDetail Class

	}

}
