package session6practice1database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dynamicsqlcodesqlinjection {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; 
	private static final String PASSWORD = ""; 

	public static void main(String[] args) {
		//this structure is not secure because when client enter( id = 2 or 1=1 )all table show this problem is said 
		//SQl injection ---------------------------------------------------
		String id="6";        //"2 or 1=1"
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID="+ id)) {
		while (resultset.next()) {
			String firstname=resultset.getString("FIRST_NAME");
			String departmentid=resultset.getString("DEPARTMENT_ID" );
			System.out.println("name: "+ firstname +" deparmnet-id: "+ departmentid);
			
		}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
