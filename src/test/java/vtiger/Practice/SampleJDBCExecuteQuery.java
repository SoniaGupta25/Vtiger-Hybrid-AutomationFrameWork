package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {


	public static void main(String[] args) throws Throwable {
		
		//Get Driver from mysql jar and register this in driver manager
		Driver driverRef = new Driver();
		
      //Step 1: register the Driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the connection with driver - provide DB name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
		
		//Step 3: issue create statement
	Statement state = con.createStatement();
		
		//Step 4: execute the query - provide table name
		      ResultSet result = state.executeQuery("select * from sampletable;");
		   while(result.next()) {
			   System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		   }
		      
	//Step 5: close the database 
		   con.close();
		
	}


}
