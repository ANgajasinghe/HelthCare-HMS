package healthcare.doctors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.DoctorDTO;
import utility.ConnectionBuilder;

public class SessionModel {

	private final ConnectionBuilder cBuilder = new ConnectionBuilder();

	public boolean connectionChecker(Connection MYSQLcon) {

		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}

	public List<DoctorDTO> getSessionData(String hospitalID, String docID, String Date) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();

		String currentData = df.format(dateobj);

		List<DoctorDTO> sessionList = new ArrayList<DoctorDTO>();
		Connection MYSQLcon = cBuilder.MYSQLConnection();

		if (this.connectionChecker(MYSQLcon)) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT \n");
			sBuilder.append("s.session_id,");
			sBuilder.append("s.hostpital_id,");
			sBuilder.append("s.available_date,");
			sBuilder.append("s.start_time,");
			sBuilder.append("s.end_time,");
			sBuilder.append("s.isEveryday,");
			sBuilder.append("d.doc_reg_no,");
			sBuilder.append("d.doc_first_name,");
			sBuilder.append("d.doc_last_name,");
			sBuilder.append("d.doc_tp1,");
			sBuilder.append("d.doc_city,");
			sBuilder.append("d.doc_email,");
			sBuilder.append("p.specification_name \n");
			sBuilder.append("FROM doc_session s \n");
			sBuilder.append("INNER JOIN doctors d ON d.doc_id = s.doc_id \n");
			sBuilder.append("INNER JOIN doc_specification p ON p.specification_id = d.doc_specification_id \n");
			sBuilder.append("WHERE (s.available_date >= ? || s.isEveryday = 1)");

			if (hospitalID != null) {
				sBuilder.append("\n AND s.hostpital_id =" + hospitalID);
			}
			if (docID != null) {
				sBuilder.append("\n AND s.doc_id =" + docID);
			}

			sBuilder.append("\n AND s.isActive = 1");

			String queryString = sBuilder.toString();

			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				if (Date == null) {
					pStatement.setString(1, currentData);
				} else {
					pStatement.setString(1, Date);
				}

				ResultSet rs = pStatement.executeQuery();
				while (rs.next()) {
					DoctorDTO dto = new DoctorDTO();

					dto.setSession_id(rs.getInt("session_id"));
					dto.setDoc_first_name(rs.getString("doc_first_name"));
					dto.setSpecification_name(rs.getString("specification_name"));
					dto.setHospital_id(rs.getInt("hostpital_id"));

					sessionList.add(dto);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}

		return sessionList;

	}

	public DoctorDTO getSessionDataById(int sessionId) {
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		DoctorDTO dto = new DoctorDTO();
		if (this.connectionChecker(MYSQLcon)) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT \n");
			sBuilder.append("* \t");
			sBuilder.append("FROM \n");
			sBuilder.append("doc_session \n");
			sBuilder.append("WHERE 	session_id =? AND isActive = 1\n");

			String queryString = sBuilder.toString();

			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				pStatement.setInt(1, sessionId);

				ResultSet rs = pStatement.executeQuery();
				while (rs.next()) {
					dto.setSession_id(rs.getInt("session_id"));
					dto.setHospital_id(rs.getInt("hostpital_id"));
					dto.setDoc_id(rs.getInt("doc_id"));
					dto.setAvailable_date(rs.getString("available_date"));
					dto.setStart_time(rs.getString("start_time"));
					dto.setEnd_time(rs.getString("end_time"));
					dto.setIsEveryday(rs.getInt("isEveryday"));
					dto.setIsActive(rs.getInt("isActive"));
					dto.setPatient_limit(rs.getInt("patient_limit"));
					dto.setPrice(rs.getDouble("price"));
					return dto;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				dto.setIsActive(0);
				return dto;
			} finally {
				try {
					MYSQLcon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("connection not establish correctly");
		}
		
		return null;
	}
}