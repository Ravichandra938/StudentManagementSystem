package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL ="jdbc:mysql://localhost:3306/student_db";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
