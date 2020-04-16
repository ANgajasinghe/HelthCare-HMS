package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.PatientDto;
import utility.ConnectionBuilder;
import utility.Messages;

public class PatientModel {
	private final ConnectionBuilder cBuilder = new ConnectionBuilder();

	public boolean connectionChecker(Connection MYSQLcon) {

		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	public String insertIntoPatient(PatientDto dto) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		if (this.connectionChecker(MYSQLcon)) {

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("INSERT INTO patients ( \n");
			sBuilder.append("first_name,");
			sBuilder.append("last_name )\n");
			sBuilder.append("VALUES (\n");
			sBuilder.append("?,?\n");
			sBuilder.append(")");

			String queryString = sBuilder.toString();
			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1,dto.getFirst_name());
				pStatement.setString(2,dto.getLast_name());

				boolean result = pStatement.execute();

				if (!result) {
					
					return this.getInsertedRecodeId();
					
				//return Messages.doctorSuccess;
				}
			} catch (SQLException e) {
				return e.toString();
			} finally {
				try {
					MYSQLcon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return Messages.connectionER;

	}	
	
	private String getInsertedRecodeId() {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT patient_id  FROM patients ORDER BY time DESC LIMIT 1");
		String qurtString = sBuilder.toString();
		try {
			Statement st = MYSQLcon.createStatement();
			ResultSet rSet= st.executeQuery(qurtString);
			if(rSet.next()) {
				return rSet.getString("patient_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
