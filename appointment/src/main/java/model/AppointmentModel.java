package model;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import dto.AppoinmentDTO;

public class AppointmentModel {
	
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;
	
	
	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final  Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
	public AppointmentModel() {
		super();
		try {
			fh = new FileHandler("C:/PAF/log/MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO ) {


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
			

			pStatement.execute();
			//logger.info(token);
			//return "false";
		} catch (SQLException e) {
			logger.info(e.toString());
			e.printStackTrace();
		} finally {
			try {
				MYSQLcon.close();
			} catch (SQLException e) {
			}
		}

		//logger.info(LMessage.sqlInsertErr);
		return "false";

	}
	
	
	
	
 public AppoinmentDTO getAppointmentData() {

		AppoinmentDTO appDTO = new AppoinmentDTO();

		Connection MYSQLcon = cBuilder.MYSQLConnection();

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
				appDTO.setApp_doc_work_id(rs.getInt("app_doc_work_id"));
				appDTO.setApp_patient_id(rs.getInt("app_patient_id"));
				appDTO.setApp_patient_name(rs.getString("app_patient_name"));
				appDTO.setApp_hospital_name(rs.getString("app_hospital_name"));
				appDTO.setApp_book_date(rs.getDate("app_book_date"));
				appDTO.setApp_patient_contact_no(rs.getInt("app_patient_contact_no"));
				appDTO.setApp_payment_status(rs.getString("app_payment_status"));
			
			}
			return appDTO;
		} catch (SQLException e) {
			System.out.println("calling");
			e.printStackTrace();
			return appDTO;
		} finally {
			try {
				MYSQLcon.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
 


}
