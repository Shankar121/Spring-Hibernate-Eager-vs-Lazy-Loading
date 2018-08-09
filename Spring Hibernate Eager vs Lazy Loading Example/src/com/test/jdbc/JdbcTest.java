package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
public static void main(String[] args) {
	String jdbcURL="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
	String username="hbstudent";
	String password="hbstudent";
	
	try {
		Connection con=DriverManager.getConnection(jdbcURL,username,password);
		System.out.println("connection successful!!");
	}catch(Exception ex) {
		
	}
}
}
