package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean insertIntoPatient(PatientDto dto) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		if (this.connectionChecker(MYSQLcon)) {

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("INSERT INTO patients ( \n");
			sBuilder.append("first_name,");
			sBuilder.append("last_name,");
			sBuilder.append("NIC,");
			sBuilder.append("DOB,");
			sBuilder.append("Password )\n");
			sBuilder.append("VALUES (\n");
			sBuilder.append("?,?,?,?,?\n");
			sBuilder.append(")");

			String queryString = sBuilder.toString();
			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1,dto.getFirst_name());
				pStatement.setString(2,dto.getLast_name());
				pStatement.setString(3,dto.getNIC());
				pStatement.setString(4,dto.getDOB());
				pStatement.setString(5,dto.getPassword());

				boolean result = pStatement.execute();

				if (!result) {
					
					return true;
					
				//return Messages.doctorSuccess;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					MYSQLcon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return false;

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
	
	public List<PatientDto> getPatients() {
		List<PatientDto> list = new ArrayList<PatientDto>();
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		String sql = "select * from patients";//table

		try {
			Statement st = MYSQLcon.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				PatientDto a = new PatientDto();

				a.setPatient_id(rs.getInt(1));
				a.setFirst_name(rs.getString(2));
				a.setLast_name(rs.getString(3));
				a.setNIC(rs.getString(4));
				a.setDOB(rs.getString(5));
				a.setPassword(rs.getString(6));

				list.add(a);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	public PatientDto getPatient(String id) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		String sql = "select * from patients where NIC=" + id;
		PatientDto a = new PatientDto();

		try {
			Statement st = MYSQLcon.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				a.setPatient_id(rs.getInt(1));
				a.setFirst_name(rs.getString(2));
				a.setLast_name(rs.getString(3));
				a.setNIC(rs.getString(4));
				a.setDOB(rs.getString(5));
				a.setPassword(rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}
	
	
	public void update(PatientDto a1) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		String sql = "update patients set first_name=? where NIC=?;";

		try {
			PreparedStatement st = MYSQLcon.prepareStatement(sql);

			st.setString(1, a1.getFirst_name());
			st.setString(2, a1.getNIC());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String NIC) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		String sql = "delete from patients where NIC=?;";

		try {
			PreparedStatement st = MYSQLcon.prepareStatement(sql);

			st.setString(1, NIC);

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	
}
