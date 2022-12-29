package com.project.quiz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllResult extends SqlConnection {   //// @ author Govardhan Jadhav and Suraj Bondage

	public void getResult() {
		try {
			AllResult allresult = new AllResult();
			connection = allresult.connectionTest();
			PreparedStatement statement = connection.prepareStatement("select * from studentdata1 order by first_name ");// here we fetch data from database ascending order of first name
			ResultSet values = statement.executeQuery();// query executed here

			System.out.println();
			System.out.println("                                     Result Of All Student                                ");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("|  %-20s|  %-20s|  %-20s|  %-40s|  %-8s|  %-9s|", "First Name", "Last Name", "Address",
					"Email_id", "Marks", "Grade");
			System.out.println();
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------");
			while (values.next()) {
				String fname = values.getString(2);
				String lname = values.getString(3);
				String address = values.getString(4);   // // print the all data of studentdata table of quiz schema
				String emailid = values.getString(5);
				String marks = values.getString(7);
				String grade = values.getString(8);
				System.out.println();
				System.out.printf("|  %-20s|  %-20s|  %-20s|  %-40s|  %-8s|  %-9s|", fname, lname, address, emailid,
						marks, grade);
				System.out.println();
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
