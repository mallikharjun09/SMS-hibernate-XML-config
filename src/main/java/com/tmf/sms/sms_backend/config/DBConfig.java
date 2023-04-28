package com.tmf.sms.sms_backend.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConfig {
	private static Connection con;
	public static Connection getDBConnection() {
		String url = "jdbc:mysql://localhost:3306/cijd_12";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database has been connected successfully..");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connected with Database successfully...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		getDBConnection();
	}
}
