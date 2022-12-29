package com.project.quiz;

import java.util.Scanner;

public class StartingWindow {      // @ author Govardhan Jadhav and Suraj Bondage
	public static void main(String[] args) {         // Program Execution Will be Start From Here
		int input;
		System.out.println(
				"|--------------------------------------------------------------------------------------------------|");
		System.out.println(
				"                    		**  Welcom To Quiz Managment System  **			                        ");
		System.out.println();
		System.out.println(
				"                                    Devloped By Velocity Group T                                      ");
		System.out.println(
				"|--------------------------------------------------------------------------------------------------|");
		System.out.println();
		System.out.println();
		System.out.println("Press 1  --->  For New Registration");
		System.out.println();
		System.out.println("Press 2  --->  For Login Existing User");
		System.out.println();
		System.out.println("Press 3  --->  For See Individual Student Result");
		System.out.println();
		System.out.println("Press 4  --->  For See All Student Result");
		System.out.println();
		Scanner scanner = new Scanner(System.in);      // call the Scanner class for taking input from user site..
		input = scanner.nextInt();
		if (input == 1) {                                // here we check condition if input is 1 then it will call getRegistration method of StudentData Class
			StudentData studentData = new StudentData();
			studentData.getRegistration();                 // here we call the getRegistration method of StudentData Class for New Registration
		} else if (input == 2) {							//here we check condition if input is 2 then it will call getLogin Method of LoginDetails Class
			LoginDetails loginDetails = new LoginDetails(); // here we call the getLogin Method of LoginDetails Class for Existing User Login
			loginDetails.getLogin();
		} else if (input == 3) {							//here we check condition if input is 3 then it will call getLogin Method of Individualresult Class
			Individualresult i = new Individualresult();  // here we call the getLogin Method of Individualresult Class for Unique Result
			i.getLogin();
		} else if (input == 4) { //here we check condition if input is 4 then it will call getResult Method of AllResult Class
			System.out.print("Press 1 --> For Display Result Name Wise                               ");
			System.out.println("Press 2 --> For Display Result Marks Wise");
			      int input1=scanner.nextInt();
			      if(input1==1) {
			    	  AllResult allresult = new AllResult();    // here we call the getResult Method of AllResult Class of All Student Result First Name Wise
						allresult.getResult();  
			      }
			      if(input1==2)
			      {
			    	  AllResult1 allresult1 = new AllResult1();    // here we call the getResult Method of AllResult Class of All Student Result Marks Wise
						allresult1.getResult();
			      }
			
		} else {
			System.err.println("Invalid Input");     // if the input none of above then here we Print the Error Message for Invalid Option
		}
	}

}
