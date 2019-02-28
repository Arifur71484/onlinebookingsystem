package com.camunda.demo.OnlineBookingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckLogin implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		LOGGER.info("Processing request by '" + execution.getVariable("email") + "'...");
		  String ab = (String) execution.getVariable("email");
		  LOGGER.info("Processing request by '" + ab + "'...");
		 
		  
		  
			    final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

			    final String DB_URL = "jdbc:mysql://localhost/n?useUnicode=yes&characterEncoding=UTF-8";
			    final String USER = "root";
			    final String PASS = "";
			  
			    final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);DriverManager.getConnection("jdbc:mysql://localhost:3307/dbname?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

			        try{
			            Class.forName(JDBC_DRIVER);         
			            System.out.print("Connecting to a selected database... ");	            
			            System.out.println("Success!");     
			            Statement statement = conn.createStatement();
			            String abc = (String) execution.getVariable("email");
			            String abcd = (String) execution.getVariable("password");
			            ResultSet set = statement.executeQuery("select * from storage WHERE email= '"+ abc + "' AND password='"+ abcd + "';");
			            while(set.next()){
			            	String resul = set.getString(4);
			 	            String results = set.getString(6);	 	           
			 	            if((resul.equals(abc)) && (results.equals(abcd))){
			 	            	//result = true;
			 	            	LOGGER.info("this is a prove it is working '" + set.getString(4) + "'...");
			 	            	execution.setVariable("user","true");
			 	            }else{
			 	            	LOGGER.info("not valid user pls enter correct email and password '" + set.getString(4) + "'..."); 
			 	            	execution.setVariable("user","false");
			 	            }
			 	            break;
			            }
			           
			        }catch(Exception e){
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


