package com.example.demo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
    public void loadDriver() {
    	System.out.println("Loading driver ...");

    	 try {
    	     Class.forName("com.mysql.cj.jdbc.Driver"); // Use com.mysql.jdbc.Driver if you're not on MySQL 8+ yet.
    	     System.out.println("Driver loaded!");
    	 } catch (ClassNotFoundException e) {
    	     throw new IllegalStateException("Cannot find the driver in the classpath!", e);
    	 }
    }
    
    public void makeConnection() {
    	String url = "jdbc:mysql://localhost:3306/car_db";
    	 String username = "root";
    	 String password = "Echo@2010";
    	
    	try {
    		
    		Connection connection = DriverManager.getConnection(url, username, password) ;
    		 System.out.println("Database connected! " + connection.getSchema());
    		
    	}
    	catch (SQLException ex){
    		
    		System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    		
    	}
    	
    }
}
