package session6exerciseDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class createlistfromdb {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; 
	private static final String PASSWORD = ""; 
	public static void main(String[] args) throws SQLException {
	
	//1)list DEPARTMENT_NAME belong to COUNTRY_ID=US-----------------------------------
		String countid="US";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedstatement = connection.prepareStatement("""
						SELECT d.DEPARTMENT_NAME
						FROM DEPARTMENTS d
						JOIN LOCATIONS l
						ON d.LOCATION_ID = l.LOCATION_ID
						WHERE l.COUNTRY_ID = ?
						
						""")) 
		{
			System.out.println("Connected to the H2 database successfully!");
			preparedstatement.setString(1, countid);
			try (ResultSet resultset = preparedstatement.executeQuery()) 
			{
				while (resultset.next()) {
					String departmentname=resultset.getString("DEPARTMENT_NAME");
					System.out.println("departments in "+countid+ " are: " + departmentname);	
				}
				
			}
			
		}
		System.err.println("*************************");
		
	//2) list employees form department-id=1-----------------------------------------------------------
		String depid="1";
		try (Connection connection1 = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement preparedstatement1 = connection1.prepareStatement("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =?")) 
		{
			System.out.println("Connected to the H2 database successfully!");
			preparedstatement1.setString(1, depid);
			try (ResultSet resultset1 = preparedstatement1.executeQuery()) 
			{
				
				while (resultset1.next()) {
					String firstname=resultset1.getString("FIRST_NAME");
					String departmentid=resultset1.getString("DEPARTMENT_ID" );
					System.out.println("name: "+ firstname +" deparmnet-id: "+ departmentid);
					
				}
			}
	
		}
	System.err.println("*********************************************");	
	//3)insert one employee to employee table----------------------------------------------------------	
	try (
		 Connection connection3 = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedstatement3 = connection3.prepareStatement
						("INSERT INTO EMPLOYEES (EMPLOYEE_ID ,FIRST_NAME ,LAST_NAME ,EMAIL ,PHONE_NUMBER ,HIRE_DATE ,JOB_ID ,SALARY ,MANAGER_ID ,DEPARTMENT_ID ) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?)")) 
	    {   System.out.println("Connected to the H2 database successfully!");
	    	preparedstatement3.setString(1, "403");
	    	preparedstatement3.setString(2, "kimiaa");
	    	preparedstatement3.setString(3, "hosseinii");
	    	preparedstatement3.setString(4, "@yahoo");
	    	preparedstatement3.setString(5, "0938");
	    	preparedstatement3.setString(6, "1993-01-13");
	    	preparedstatement3.setString(7, "5");
	    	preparedstatement3.setString(8, "100");
	    	preparedstatement3.setString(9, null);
	    	preparedstatement3.setString(10, "1");
	    	
	    	int rowsAffected = preparedstatement3.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the country table.");

		}
	System.err.println("*********************************************4");	
	//4) update countries table , change country-name with country-id=AR to ARGENTINAAAA-----------
    try (
            Connection connection4 = DriverManager.getConnection(URL, USER, PASSWORD);                
    		PreparedStatement preparedStatement4 = connection4.prepareStatement(
    				"UPDATE COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ?") 
        ) {
            System.out.println("Connected to the H2 database successfully!");
            preparedStatement4.setString(1, "ARGENTINAAAA"); 
            preparedStatement4.setString(2, "AR");

            int rowsAffected = preparedStatement4.executeUpdate();
            System.out.println("Updated " + rowsAffected + " row(s) in the country table.");
        } 
	
		
		

	
	
	}

}
