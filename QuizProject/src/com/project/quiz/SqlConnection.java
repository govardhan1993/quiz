package com.project.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {    // // @ author Suraj Bondage and Kajal Juwar
	Connection connection = null;

	public Connection connectionTest() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  // jdbc driver acessed here
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "1993");    // load the drivermanager class for database connection

		} catch (Exception e) {

			System.out.println(e);
		}
		return connection;

	}

}
