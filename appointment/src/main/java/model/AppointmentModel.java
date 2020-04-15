package model;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.AppoinmentDTO;

public class AppointmentModel {
	
	
	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final  Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
public boolean connectionChecker() {
		
		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}

	
	
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO ) {


		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("INSERT INTO \n");
		sBuilder.append("appointment (app_doc_work_id,app_patient_id,app_patient_name,app_hospital_name,app_book_date,app_patient_contact_no,app_payment_status) VALUES( \n");
		sBuilder.append("?,?,?,?,?,?,? )");

		String queryString = sBuilder.toString();

		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, appoinmentDTO.getApp_doc_work_id());
			pStatement.setInt(2, appoinmentDTO.getApp_patient_id());
			pStatement.setString(3, appoinmentDTO.getApp_patient_name());
			pStatement.setString(4, appoinmentDTO.getApp_hospital_name());
			pStatement.setDate(5, (Date) appoinmentDTO.getApp_book_date());
			pStatement.setInt(6, appoinmentDTO.getApp_patient_contact_no());
			pStatement.setString(7, appoinmentDTO.getApp_payment_status());
			

			boolean result = pStatement.execute();
			
			if (!result) {
				return "dataADDEDSuccess";
			}
		
			
			this.MYSQLcon.close();
		
		} catch (SQLException e) {
			return e.toString();
		}
		
	return "connectionER";
}
	

	
	
	
	
 public List<AppoinmentDTO> getAppointmentData() {

		List<AppoinmentDTO> appDTOList = new ArrayList<AppoinmentDTO>();
		//Connection MYSQLcon = cBuilder.MYSQLConnection();
		
		
		if (this.connectionChecker()) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("*\t,");
			sBuilder.append("FROM\n");
			sBuilder.append("appointment\n");
		
			String queryString = sBuilder.toString();
	
		
		try {
			Statement stmt = this.MYSQLcon.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				AppoinmentDTO appDTO = new AppoinmentDTO();
				appDTO.setApp_doc_work_id(rs.getInt("app_doc_work_id"));
				appDTO.setApp_patient_id(rs.getInt("app_patient_id"));
				appDTO.setApp_patient_name(rs.getString("app_patient_name"));
				appDTO.setApp_hospital_name(rs.getString("app_hospital_name"));
				appDTO.setApp_book_date(rs.getDate("app_book_date"));
				appDTO.setApp_patient_contact_no(rs.getInt("app_patient_contact_no"));
				appDTO.setApp_payment_status(rs.getString("app_payment_status"));
				appDTOList.add(appDTO);
			
			}
			this.MYSQLcon.close();
			return appDTOList;
			
		} catch (SQLException e) {
			System.out.println("calling");
			e.printStackTrace();
			return appDTOList;
		} 
		
		}
		
 return null;
 }
}



