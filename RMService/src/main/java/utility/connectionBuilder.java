package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class connectionBuilder {

	
	public static  Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public PreparedStatement prepareStatement(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
