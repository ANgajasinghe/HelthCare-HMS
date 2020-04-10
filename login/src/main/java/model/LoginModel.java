package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import auth.AuthToken;
import dto.UserDTO;

public class LoginModel {

	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final  Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
	public boolean connectionChecker() {
		
		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	
	
	public boolean checkUser(String username,String user_password) {
		
		UserDTO userDTO = this.getUserBYPassword(username, user_password);

		
		if(userDTO != null) {

			this.InsertIntoLogin(
					userDTO.getUsername(),
					userDTO.getUser_password(),
					userDTO.getUser_role());
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private UserDTO getUserBYPassword(String username , String user_password){
		 
		UserDTO userDTO = new UserDTO();
		
		if(connectionChecker()) {
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("user_id,");
			sBuilder.append("username,");
			sBuilder.append("user_email,");
			sBuilder.append("user_password,");
			sBuilder.append("user_role\n");
			sBuilder.append("FROM\n");
			sBuilder.append("userprofile\n");
			sBuilder.append("WHERE\n");
			sBuilder.append("(username = ? OR user_email = ?)\n");
			sBuilder.append("AND\n");
			sBuilder.append("(user_password = ?)\n");
		
			String queryString = sBuilder.toString();
			
			try {
				PreparedStatement pStatement = this.MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1, username);
				pStatement.setString(2, username);
				pStatement.setString(3, user_password);
				
				ResultSet rs =  pStatement.executeQuery();
				
			
				while (rs.next()) {
					userDTO.setUser_id(rs.getInt("user_id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setUser_email(rs.getString("user_email"));
					userDTO.setUser_password("user_password");
					userDTO.setUser_role(rs.getString("user_role"));
					break;
				}
				
				return userDTO;	
			} catch (SQLException e) {
				e.printStackTrace();
				return userDTO;
			}
				
		}
		return userDTO; 
	}
	
	private void InsertIntoLogin(String userName ,String password ,String role) {
		System.out.println("Calling");
		String string= AuthToken.getToken(userName, password, role);
		System.out.println(AuthToken.VerifyToken(string));
	}
	

	
	

	
	
}