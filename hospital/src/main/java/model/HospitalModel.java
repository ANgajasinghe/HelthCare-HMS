package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectionBuilder;

public class HospitalModel {

	private final ConnectionBuilder cBuilder = new ConnectionBuilder();
	
	public boolean connectionChecker(Connection MYSQLcon) {

		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	public String getHospitalIdByuserId(String userID) {
		
		String result = null;
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT\n");
		sBuilder.append(" * \t");
		sBuilder.append("FROM\n");
		sBuilder.append("hospital_users\n");
		sBuilder.append("WHERE host_user_id = ?\n");
		
		String queryString = sBuilder.toString();
		
		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setString(1, userID.trim());
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				result = rs.getString("hospital_id")+","+rs.getString("host_user_name");
				return result;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			try {
//				//MYSQLcon.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

		return result;

	}
}
