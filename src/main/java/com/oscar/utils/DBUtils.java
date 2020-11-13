package com.oscar.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {
	public static Connection DBConnection() {
		
		Connection connection = null;
		Context ctx = null;
		try {
			ctx = new InitialContext();
			DataSource ds  = (DataSource) ctx.lookup("java:/comp/env/jdbc/ColegioDB");
			connection = ds.getConnection();
		} catch (NamingException | SQLException  e) {
			e.printStackTrace();
		}
		return connection;
		
	}
}
