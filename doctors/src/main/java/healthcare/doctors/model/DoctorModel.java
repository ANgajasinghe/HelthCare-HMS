package healthcare.doctors.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.DoctorDTO;
import healthcare.doctors.DTO.SpecificationDTO;
import utility.ConnectionBuilder;
import utility.Messages;


public class DoctorModel implements IDataModel {
	
	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final  Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
	@Override
	public boolean connectionChecker() {
		
		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<DoctorDTO> getSepecificationAllData() 
	{
		
		List<DoctorDTO> specificationDTOliList = new ArrayList<DoctorDTO>();
		
		if (this.connectionChecker()) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append(SpecificationDTO.specification_id +",");
			sBuilder.append(SpecificationDTO.specification_name +",");
			sBuilder.append(SpecificationDTO.specification_dis+"\n");
			sBuilder.append("FROM\n");
			sBuilder.append(SpecificationDTO.TABE_NAME);
			
			String qurtString = sBuilder.toString();
			
			try {
				Statement stmt = this.MYSQLcon.createStatement();
				ResultSet rs = stmt.executeQuery(qurtString);
				
				while (rs.next()) {
					DoctorDTO dto = new DoctorDTO();
					dto.setSpecification_id(rs.getInt(SpecificationDTO.specification_id));
					dto.setSpecification_name(rs.getString(SpecificationDTO.specification_name));
					dto.setSpecification_dis((rs.getString(SpecificationDTO.specification_dis) != null) ? 
							rs.getString(SpecificationDTO.specification_dis) : Messages.NODATA);
					specificationDTOliList.add(dto);	
				}
				this.MYSQLcon.close();
				return specificationDTOliList;
				
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
				return specificationDTOliList;
			}
			
		}
		return specificationDTOliList;
		
	}

	@Override
	public List<DoctorDTO> getAllDoctors() {
		List<DoctorDTO> allDocList = new ArrayList<DoctorDTO>();
		if (this.connectionChecker()) {
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("*\t");
			sBuilder.append("FROM\n");
			sBuilder.append("doctors");
			
			String qurtString = sBuilder.toString();
			
			
			try {
				Statement stmt = this.MYSQLcon.createStatement();
				ResultSet rs = stmt.executeQuery(qurtString);
				
				while (rs.next()) {
					DoctorDTO dto = new DoctorDTO();
					dto.setDoc_id(rs.getInt("doc_id"));
					dto.setDoc_reg_no(rs.getString("doc_reg_no"));
					dto.setDoc_first_name(rs.getString("doc_first_name"));
					dto.setDoc_last_name(rs.getString("doc_last_name"));
					dto.setDoc_address_no(rs.getString("doc_address_no"));
					dto.setDoc_address_lane1(rs.getString("doc_address_lane1"));
					dto.setDoc_address_lane2(rs.getString("doc_address_lane2"));
					dto.setDoc_address_lane3(rs.getString("doc_address_lane3"));
					dto.setDoc_city(rs.getString("doc_city"));
					dto.setDoc_tp1(rs.getString("doc_tp1"));
					dto.setDoc_tp2(rs.getString("doc_tp2"));
					dto.setDoc_tp3(rs.getString("doc_tp3"));
					dto.setDoc_email(rs.getString("doc_email"));
					dto.setDoc_status_id(rs.getInt("doc_status_id"));
					dto.setSpecification_id(rs.getInt("doc_specification_id"));
					dto.setHospital_id(rs.getInt("doc_host_id"));
					dto.setWard_id(rs.getInt("doc_word_id"));
					allDocList.add(dto);
				}
				this.MYSQLcon.close();
				return allDocList;
				
			} catch (SQLException e) {
				DoctorDTO dto = new DoctorDTO();
				dto.setSpecification_dis(e.toString());
				allDocList.add(dto);
				return allDocList;
			}
			
			
		
			
		}
		
		return null;
	}
	
	@Override
	public String insertIntoDoctors(DoctorDTO doctorDTOs ) {
		if (this.connectionChecker()) {
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("INSERT INTO doctors ( \n");
			sBuilder.append("doc_reg_no,");
			sBuilder.append("doc_first_name,");
			sBuilder.append("doc_last_name,");
			sBuilder.append("doc_address_no,");
			sBuilder.append("doc_address_lane1,");
			sBuilder.append("doc_address_lane2,");
			sBuilder.append("doc_address_lane3,");
			sBuilder.append("doc_city,");
			sBuilder.append("doc_tp1,");
			sBuilder.append("doc_tp2,");
			sBuilder.append("doc_tp3,");
			sBuilder.append("doc_email,");
			sBuilder.append("doc_status_id,");
			sBuilder.append("doc_specification_id,");
			sBuilder.append("doc_host_id,");
			sBuilder.append("doc_word_id)\n");
			sBuilder.append("VALUES (\n");
			sBuilder.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?\n");
			sBuilder.append(")");
			
			
			String queryString = sBuilder.toString();
			try {
				PreparedStatement pStatement = this.MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1,doctorDTOs.getDoc_reg_no() != null ? doctorDTOs.getDoc_reg_no():null );
				pStatement.setString(2,doctorDTOs.getDoc_first_name() != null ? doctorDTOs.getDoc_first_name():null );
				pStatement.setString(3,doctorDTOs.getDoc_last_name() != null ? doctorDTOs.getDoc_last_name():null );
				
				pStatement.setString(4,doctorDTOs.getDoc_address_no() != null ? doctorDTOs.getDoc_address_no():null );
				pStatement.setString(5,doctorDTOs.getDoc_address_lane1() != null ? doctorDTOs.getDoc_address_lane1():null );
				pStatement.setString(6,doctorDTOs.getDoc_address_lane2() != null ? doctorDTOs.getDoc_address_lane2():null );
				pStatement.setString(7,doctorDTOs.getDoc_address_lane3() != null ? doctorDTOs.getDoc_address_lane3():null );
				pStatement.setString(8,doctorDTOs.getDoc_city() != null ? doctorDTOs.getDoc_city():null );
				
				pStatement.setString(9,doctorDTOs.getDoc_tp1() != null ? doctorDTOs.getDoc_tp1():null );
				pStatement.setString(10,doctorDTOs.getDoc_tp2() != null ? doctorDTOs.getDoc_tp2():null );
				pStatement.setString(11,doctorDTOs.getDoc_tp3() != null ? doctorDTOs.getDoc_tp3():null );
				pStatement.setString(12,doctorDTOs.getDoc_email() != null ? doctorDTOs.getDoc_email():null );
				
				pStatement.setInt(13,doctorDTOs.getDoc_status_id() != null ? doctorDTOs.getDoc_status_id():0 );
				pStatement.setInt(14,doctorDTOs.getSpecification_id() != null ? doctorDTOs.getSpecification_id():0 );
				pStatement.setInt(15,doctorDTOs.getHospital_id() != null ? doctorDTOs.getHospital_id():0 );
				pStatement.setInt(16,doctorDTOs.getWard_id() != null ? doctorDTOs.getWard_id():null );
				
				boolean result = pStatement.execute();
				
				if (!result) {
					return Messages.dataSuccess;
				}
			
				
				this.MYSQLcon.close();
			
			} catch (SQLException e) {
				return e.toString();
			}
			
		}
	    return Messages.connectionER;
		
		
	}

	

	


	
	

}
