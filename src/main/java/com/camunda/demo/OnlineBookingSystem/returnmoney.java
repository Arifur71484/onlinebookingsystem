package com.camunda.demo.OnlineBookingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class returnmoney implements JavaDelegate {
	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {

	
	LOGGER.info("Processing request by '" + execution.getVariable("email") + "'...");
	String ab = (String) execution.getVariable("email");
	LOGGER.info("Processingggg request by '" + ab + "'...");
	   final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

	    final String DB_URL = "jdbc:mysql://localhost/n?useUnicode=yes&characterEncoding=UTF-8";
	    final String USER = "root";
	    final String PASS = "";
		    final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

		        try{
		            Class.forName(JDBC_DRIVER);         
		            System.out.print("Connecting to a selected database... ");
		            
		            System.out.println("Success!");     
		            Statement statement = conn.createStatement();
		            String abc = (String) execution.getVariable("email");
		            LOGGER.info("Processingggg requestttt by '" + abc + "'...");
		            statement.executeUpdate("DELETE from payment WHERE email= '"+ abc + "';");
		            
		           
		        }catch(Exception e){
		            //Handle errors for JDBC
		            e.printStackTrace();
		        }
		       
		        try{
		            if(conn!=null)
		            conn.close();
		        }catch(SQLException se){
		            se.printStackTrace();
		        }
		        System.out.println("Connection closed");
		    
	}


}
