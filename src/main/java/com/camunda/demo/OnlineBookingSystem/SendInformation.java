package com.camunda.demo.OnlineBookingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendInformation implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		
		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

		    final String DB_URL = "jdbc:mysql://localhost/n?useUnicode=yes&characterEncoding=UTF-8";
		    final String USER = "root";
		    final String PASS = "1234";
			    final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			        try{
			             
			            Class.forName(JDBC_DRIVER);         
			       
			            System.out.print("Connecting to a selected database... ");
			            
			            System.out.println("Success!");     
			            Statement statement = conn.createStatement();
			            
			           //statement.executeUpdate("INSERT INTO booking(roomtype, roomprice) VALUES ('"+ execution.getVariable("roomtype")+"', " + execution.getVariable("roomprice")+");");
				       ResultSet max=statement.executeQuery("SELECT MAX(ID) FROM booking");
				        statement.executeQuery ("select roomtype,roomprice from booking where ID=max");
				        //send raw information to hotel authority			            
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
