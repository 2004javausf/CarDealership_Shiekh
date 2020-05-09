package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnFactory {

	private static ConnFactory cf= new ConnFactory();
	
	private ConnFactory() {
		super();
	}
	public static synchronized ConnFactory getInstance() {
		if(cf == null){
			cf = new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		String url="jdbc:oracle:thin:@javaahmad.c4rnrvsjw9j4.us-west-1.rds.amazonaws.com:1521:ORCL";
		String username="AhmadMM10";
		String password="MOONmoon24633";
		Connection conn=null;
		try {
			
			conn=DriverManager.getConnection(url,username,password);
		  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}

