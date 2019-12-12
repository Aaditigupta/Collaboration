package com.mindtree.sendandpost.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {

	public Connection getConnection() {
		Connection result = null;

		try {
			result = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitycollege", "root", "Welcome123");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}
}
