package com.wipro.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/convocheck", "root", "tojosoumili12");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnectionObject() {
		return con;
	}
}
