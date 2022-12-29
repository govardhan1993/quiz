package com.project.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RandomQuetions extends SqlConnection {  // // @ author Govardhan Jadhav , Kajal Juwar and Suraj Bondage
	static int count = 0;
	String input;
	String p5;
	String gread;

	public void getQuetions() throws SQLException {
		RandomQuetions randomQuetions = new RandomQuetions();
		connection = randomQuetions.connectionTest();
		PreparedStatement statement = connection.prepareStatement("select * from question1"); // write query for take questions from database randomly
																			
		ResultSet values = statement.executeQuery(); // Execute the query

		while (values.next()) {            // it return true till value present in database
			String q = values.getString(2);  // get the value of particular column of database
			String a = values.getString(3);
			String b = values.getString(4);
			String c = values.getString(5);    
			String d = values.getString(6);
			p5 = values.getString(7);       // take for correct answer
			System.out.println(q);
			System.out.println(a);       
			System.out.println(b);     //  print the questions and options on console .. take it from database
			System.out.println(c);
			System.out.println(d);
			getQuestions();

		}
		if (count >= 8 && count <= 10) {
			gread = "A";
		} else if (count >= 6 && count <= 7) {
			gread = "B";
		} else if (count == 5) {                       // here we check marks and give the grade according to their marks ..
			gread = "C";
		} else {
			gread = "fail";
		}
		String s = Integer.toString(count);                  // type casting.. convert int value into string
		RandomQuetions randomQuetions1=new RandomQuetions();
		// System.out.println("count is"+s);
		// System.out.println("grade is"+ gread);

		MarksUser markUser = new MarksUser();   //   here we use it for submit and store final marks into database
		String email = markUser.getLogin();       // getLogin method of MarkUser Class Call from here to store the grade and marks into database

		Connection connection = randomQuetions1.connectionTest();
		PreparedStatement statement1 = connection
				.prepareStatement("update studentdata1 set marks=?, grade=? where email_id=?");  // here we write query for update table value
		statement1.setString(3, email);
		statement1.setString(1, s);
		statement1.setString(2, gread);     // here we set the value into grade and marks column for particular user only..
		statement1.executeUpdate();   // query executed here
		System.out.println();
		System.out.println("               ***   Test Successfully Submitted   ***                   ");
	}

	public void getQuestions() {

		Scanner scanner = new Scanner(System.in); // here we take input from user t chose one answer
		System.out.println("Select The One Of Above");
		input = scanner.next();
		if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) { // here we check if
																								// ans=true then count
																								// will increase
			if (input.equals(p5)) { // if condition is true count will be increase

				count++;
			}
		} else {
			System.err.println("Invalid Option"); // if user chose wrong option the error massage will display

		}
	}

}
