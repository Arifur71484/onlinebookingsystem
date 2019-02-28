package com.camunda.demo.OnlineBookingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ButtonGroup;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckPayment implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution , HttpServletRequest request, HttpServletResponse response) throws Exception {
	  LOGGER.info("Processing request by '" + execution.getVariable("firstname") + "'...");
		
		    //JDBC driver name and database URL
	  
	    final String DB_URL = "jdbc:mysql://localhost/n?useUnicode=yes&characterEncoding=UTF-8";
	    final String USER = "root";
	    final String PASS = "";
	    final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
	    ButtonGroup bg1 = new ButtonGroup ();
	    
	   // bg1.add(jRadioButton1);
	    
	    String bahman= request.getParameter("yes");
	    String Arifur = request.getParameter("no");
	    String s="no";
        String y="yes";	    
	    
        if (s.equals(Arifur)) {
        	
        	System.out.println("Payment Execution cancelled");
        }else if (y.equals(bahman)) {
        	try{
	        	Class.forName("com.mysql.jdbc.Driver");
			      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/dbname?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			       Statement statement = conn.createStatement();
	            System.out.print("Connecting to a selected database... ");	            
	            System.out.println("Success!");     
	     
	            statement.executeUpdate("INSERT INTO payment(firstname, lastname, email, card,cvv, phoneno) VALUES ('"+ execution.getVariable("firstname")+"','" + execution.getVariable("lastname")+"','" + execution.getVariable("email")+"'," + execution.getVariable("card")+","+","+execution.getVariable("cvv")+"," + execution.getVariable("phoneno")+");");	        
	 	        LOGGER.info("your details has been succesfully submitted to our database");
	 	        execution.setVariable("user","true");	 	   
	 	        }catch(Exception e){
	            //Handle errors for JDBC
	            e.printStackTrace();
	            LOGGER.info(" please try again to correct the data ..."); 
	            execution.setVariable("user","false");
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
	    
	    
	    
		        


}
