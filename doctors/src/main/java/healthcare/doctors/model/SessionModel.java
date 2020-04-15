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
	
	public List<DoctorDTO> getSessionData(String hospitalID,String docID,String Date) {
		

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		
		String currentData = df.format(dateobj);
	
		List<DoctorDTO> sessionList = new ArrayList<DoctorDTO>();
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		
		if (this.connectionChecker(MYSQLcon)) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT \n");
			sBuilder.append("* \t");
			sBuilder.append("FROM\n");
			sBuilder.append("doc_session\n");
			sBuilder.append("WHERE (available_date >= ? || isEveryday = 1)");
			
			if (!(hospitalID.isEmpty() || hospitalID == null)) {
				sBuilder.append("\n AND hostpital_id ="+hospitalID);
			}
			if (!(docID.isEmpty() || docID == null)) {
				sBuilder.append("\n AND doc_id ="+docID);
			}
			
			sBuilder.append("\n AND isActive = 1");
			
			String queryString = sBuilder.toString();
			
			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				if (Date.isEmpty() || Date == null) {
					System.out.println("date is null");
					pStatement.setString(1, currentData);
				}else {
					System.out.println("date is not NUll");
					pStatement.setString(1, Date);
				}
				
				
				
				
				
				ResultSet rs = pStatement.executeQuery();
				while (rs.next()) {
					DoctorDTO dto = new DoctorDTO();
					
					dto.setSession_id(rs.getInt("session_id"));
					sessionList.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return sessionList;
		
	}
}
