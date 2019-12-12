package com.mindtree.clientPortal.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public Connection getConnection() {
		Connection result = null;

		try {
			result = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityCollege", "root", "Welcome123");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}
}
