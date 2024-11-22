package session6practice1database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dynamicsqlcodesolvesqlinjection {
	private static final String URL = "jdbc:h2:tcp://localhost:9092/~/testdb";
	private static final String USER = "sa"; 
	private static final String PASSWORD = ""; 
	public static void main(String[] args) throws SQLException {
		
		//solve sql injecetion by preparedstatement--------------------------------
		String id="9";
		try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =?")) 
		{
			System.out.println("Connected to the H2 database successfully!");
			preparedstatement.setString(1, id);
			try (ResultSet resultset = preparedstatement.executeQuery()) 
			{
				
				while (resultset.next()) {
					String firstname=resultset.getString("FIRST_NAME");
					String departmentid=resultset.getString("DEPARTMENT_ID" );
					System.out.println("name: "+ firstname +" deparmnet-id: "+ departmentid);
					
				}
			}
			
			
			
		}
		

	}

}
