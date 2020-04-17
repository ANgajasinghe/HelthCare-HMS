package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;
import utility.ConnectionBuilder;

public class UserModel {
	
	
	private final ConnectionBuilder cBuilder = new ConnectionBuilder();
	
	public boolean InsertIntoUserProfile(UserDTO dto) {
		
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("INSERT INTO \n");
		sBuilder.append("userprofile (user_id,username,user_email,user_password,user_role) VALUES( \n");
		sBuilder.append("?,?,?,?,? )");
		
		String queryString = sBuilder.toString();
		
		
		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1,dto.getUser_id());
			pStatement.setString(2,dto.getUsername());
			pStatement.setString(3, dto.getUser_email());
			pStatement.setString(4, dto.getUser_password());
			pStatement.setString(5,dto.getUser_role());
			
			boolean result = pStatement.execute();
			
			if (!result) {
				return true;
			}
			return false;
			
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		
		}
	} 
	
	public boolean checkUsernameAndPassword(UserDTO dto) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT \n");
		sBuilder.append("user_id \n");
		sBuilder.append("FROM userprofile\n");
		sBuilder.append("WHERE\n");
		sBuilder.append("username = ? OR user_email = ?");
		String queryString = sBuilder.toString();
		
		
		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setString(1,dto.getUsername());
			pStatement.setString(2, dto.getUser_email());
			
		   ResultSet rSet = pStatement.executeQuery();
		   
		   if (rSet.next()) {
			  return true;
		   }
		   
		   return false;
			
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		
		}
		
		
	}

}
