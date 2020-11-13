package com.oscar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection DBConnection() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dURL = "jdbc:mysql://localhost:3306/colegio";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(dURL,username,password) ;
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // sirve para cargar

		return connection;
		
	}
}
