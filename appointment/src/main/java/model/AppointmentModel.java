 package model;



import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.AppoinmentDTO;


public class AppointmentModel {
	
	
	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();
	//private final  Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
//public boolean connectionChecker() {
//		
////		if (MYSQLcon == null) {
////			return false;
////		}
////		return true;
//	}

	
	
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO ) {


		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("INSERT INTO \n");
		sBuilder.append("appointment ("
				+ "app_doc_id,"
				+ "app_patient_id,"
				+ "app_session_id,"
				+ "app_patient_name,"
				+ "app_hospital_name,"
				+ "app_book_date,"
				+ "app_patient_contact_no,"
				+ "app_price,"
				+ "app_payment_status)\n"
				+ " VALUES( \n");
		sBuilder.append("?,?,?,?,?,?,?,?,?)");

		String queryString = sBuilder.toString();

		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, appoinmentDTO.getApp_doc_id());
			pStatement.setInt(2, appoinmentDTO.getApp_patient_id());
			pStatement.setInt(3, appoinmentDTO.getApp_session_id());
			pStatement.setString(4, appoinmentDTO.getApp_patient_name());
			pStatement.setString(5, appoinmentDTO.getApp_hospital_name());
			pStatement.setString(6, appoinmentDTO.getApp_book_date());
			pStatement.setInt(7, appoinmentDTO.getApp_patient_contact_no());
			pStatement.setDouble(8, appoinmentDTO.getApp_price());
			pStatement.setString(9, appoinmentDTO.getApp_payment_status());
			

			System.out.println("calling Model");
			
			boolean result = pStatement.execute();
			
			if (!result) {
				return "dataADDEDSuccess";
			}
		
			
			MYSQLcon.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		
	return "connectionER";
}
	

	
	
	
	
 public List<AppoinmentDTO> getAppointmentData() {
	 System.out.println("getAppointmentData()");

		List<AppoinmentDTO> appDTOList = new ArrayList<AppoinmentDTO>();
		//Connection MYSQLcon = cBuilder.MYSQLConnection();
		
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("*\t");
			sBuilder.append("FROM\n");
			sBuilder.append("appointment\n");
		
			String queryString = sBuilder.toString();
	
		
		try {
			Statement stmt = MYSQLcon.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				AppoinmentDTO appDTO = new AppoinmentDTO();
				appDTO.setApp_doc_id(rs.getInt("app_doc_id"));
				appDTO.setApp_patient_id(rs.getInt("app_patient_id"));
				appDTO.setApp_session_id(rs.getInt("app_session_id"));
				appDTO.setApp_patient_name(rs.getString("app_patient_name"));
				appDTO.setApp_hospital_name(rs.getString("app_hospital_name"));
				//appDTO.setApp_book_date(rs.getDate("app_book_date"));
				appDTO.setApp_patient_contact_no(rs.getInt("app_patient_contact_no"));
				appDTO.setApp_price(rs.getDouble("app_price"));
				appDTO.setApp_payment_status(rs.getString("app_payment_status"));
				appDTOList.add(appDTO);
			
			}
			MYSQLcon.close();
			return appDTOList;
			
		} catch (SQLException e) {
			System.out.println("calling");
			e.printStackTrace();
			return appDTOList;
		}
 }
 
 public boolean UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
		// update 
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("UPDATE appointment \n");
		sBuilder.append("SET app_doc_id= ?,app_session_id=?, app_patient_name=?,app_hospital_name=?,app_book_date=?,app_patient_contact_no=?,app_price=?\n");
		sBuilder.append("WHERE app_patient_id= ? \n");
		

		String queryString = sBuilder.toString();

		PreparedStatement pStatement;
		try {
			pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, appoinmentDTO.getApp_doc_id());
			pStatement.setInt(3, appoinmentDTO.getApp_session_id());
			pStatement.setString(4, appoinmentDTO.getApp_patient_name());
			pStatement.setString(5, appoinmentDTO.getApp_hospital_name());
			//pStatement.setDate(6, (Date) appoinmentDTO.getApp_book_date());
			pStatement.setInt(7, appoinmentDTO.getApp_patient_contact_no());
			pStatement.setDouble(8, appoinmentDTO.getApp_price());
			pStatement.setString(9, appoinmentDTO.getApp_payment_status());
			boolean result = pStatement.execute();
			if (!result) {
				return true;
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

		return false;
	}
 
 
	public String SelecthospitalName(String app_session_id) {
		if (app_session_id != null) {
			Connection MYSQLcon = cBuilder.MYSQLConnection();
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("app_hospital_name\n");
			sBuilder.append("FROM\n");
			sBuilder.append("appointment\n");
			sBuilder.append("WHERE app_session_id = ?");
			String qurtString = sBuilder.toString();

			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(qurtString);
				pStatement.setString(1, app_session_id.trim());
				ResultSet rs = pStatement.executeQuery();
				while (rs.next()) {
					return rs.getString("app_hospital_name");
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
		return null;
	}

}



