package com.camunda.demo.OnlineBookingSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class registeration implements JavaDelegate {

	  //private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	  public void execute(DelegateExecution execution) throws Exception {

		  
		    final String DB_URL = "jdbc:mysql://localhost/n?useUnicode=yes&characterEncoding=UTF-8";
		    final String USER = "root";
		    final String PASS = "";
		    final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        try{
		        	Class.forName("com.mysql.jdbc.Driver");
				      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbname?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			      Statement stmt = con.createStatement();
		        	
		        	
		                
		            System.out.print("Connecting to a selected database... ");	            
		            System.out.println("Successfully connected!");   
		            

					      
		            
		            
		          
		            stmt.executeUpdate("INSERT INTO users(fname, lname, nationality, email, phonenumber, password, confirmpassword) VALUES ('"+ execution.getVariable("firstname")+"','" + execution.getVariable("lastname")+"','" + execution.getVariable("nationality")+"','" + execution.getVariable("email")+"'," + execution.getVariable("phoneno")+",'" + execution.getVariable("password")+"','" + execution.getVariable("conpassword")+"');");
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
