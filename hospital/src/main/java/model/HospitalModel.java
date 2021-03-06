package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.HospitalDto;
import utility.ConnectionBuilder;
//import utility.Messages;

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
//<<<<<<< HEAD
	
	
	
	public String insertIntoHospital(HospitalDto hospitalDTOs) {
		// TODO Auto-generated method stub
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("INSERT INTO hospitals ( \n");
			sBuilder.append("hospital_id,");
			sBuilder.append("hospital_name,");
			sBuilder.append("hospital_address_no,");
			sBuilder.append("hospital_address_lane1,");
			sBuilder.append("hospital_address_lane2,");
			sBuilder.append("hospital_address_lane3,");
			sBuilder.append("hospital_city,");
			sBuilder.append("tel,");
			sBuilder.append("email)\n");
			sBuilder.append("VALUES (\n");
			sBuilder.append("?,?,?,?,?,?,?,?,?\n");
			sBuilder.append(")");

			String queryString = sBuilder.toString();
			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
				pStatement.setInt(1, hospitalDTOs.getHospital_id());
				pStatement.setString(2, hospitalDTOs.getHospital_name());
				pStatement.setString(3, hospitalDTOs.getHospital_address_no());
				pStatement.setString(4, hospitalDTOs.getHospital_address_lane1());
				pStatement.setString(5, hospitalDTOs.getHospital_address_lane2());
				pStatement.setString(6, hospitalDTOs.getHospital_address_lane3());
				pStatement.setString(7, hospitalDTOs.getHospital_city());
				pStatement.setString(8, hospitalDTOs.getTel());
				pStatement.setString(9, hospitalDTOs.getEmail());
				

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
	
	
	
	public List<HospitalDto> getAllHospitals() {
		List<HospitalDto> allHospitalList = new ArrayList<HospitalDto>();
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		if (this.connectionChecker(MYSQLcon)) {

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("*\t");
			sBuilder.append("FROM\n");
			sBuilder.append("hospitals");

			String qurtString = sBuilder.toString();

			try {
				Statement stmt = MYSQLcon.createStatement();
				ResultSet rs = stmt.executeQuery(qurtString);

				while (rs.next()) {
					HospitalDto hto = new HospitalDto();
					hto.setHospital_id(rs.getInt("hospital_id"));
					hto.setHospital_name(rs.getString("hospital_name"));
					hto.setHospital_address_no(rs.getString("hospital_address_no"));
					hto.setHospital_address_lane1(rs.getString("hospital_address_lane1"));
					hto.setHospital_address_lane2(rs.getString("hospital_address_lane2"));
					hto.setHospital_address_lane3(rs.getString("hospital_address_lane3"));
					hto.setHospital_city(rs.getString("hospital_city"));
					hto.setTel(rs.getString("tel"));
					hto.setEmail(rs.getString("email"));
					allHospitalList.add(hto);
				}

				return allHospitalList;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					MYSQLcon.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return null;
	}

	
	
	
	 //update
	 public boolean UpdateHospital(HospitalDto hospitalDTO) {
			
		 Connection MYSQLcon = cBuilder.MYSQLConnection();
		 
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("UPDATE hospitals \n");
			sBuilder.append( "SET \n");
			sBuilder.append("hospital_name=?,");
			sBuilder.append("hospital_address_no=?,");
			sBuilder.append("hospital_address_lane1=?,");
			sBuilder.append("hospital_address_lane2=?,");
			sBuilder.append("hospital_address_lane3=?,");
			sBuilder.append("hospital_city=?,");
			sBuilder.append("tel=?,");
			sBuilder.append("email= ?");
			sBuilder.append(" WHERE hospital_id= ? \n");
			
			

			String queryString = sBuilder.toString();

			PreparedStatement pStatement;
			try {
				pStatement = MYSQLcon.prepareStatement(queryString);
				pStatement.setInt(1, hospitalDTO.getHospital_id());
				pStatement.setString(2, hospitalDTO.getHospital_name());
				pStatement.setString(3, hospitalDTO.getHospital_address_no());
				pStatement.setString(4, hospitalDTO.getHospital_address_lane1());
				pStatement.setString(5, hospitalDTO.getHospital_address_lane2());
				pStatement.setString(6, hospitalDTO.getHospital_address_lane3());
				pStatement.setString(7, hospitalDTO.getHospital_city());
				pStatement.setString(8, hospitalDTO.getTel());
				pStatement.setString(9,hospitalDTO.getEmail());
				
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
	 
	
	 
	 

	public String getHospitalNameByID(String id) {
		String result = null;
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT\n");
		sBuilder.append(" * \t");
		sBuilder.append("FROM\n");
		sBuilder.append("hospitals\n");
		sBuilder.append("WHERE hospital_id  = ?\n");
		String queryString = sBuilder.toString();
		
		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setString(1, id.trim());
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				result = rs.getString("hospital_name")+","+rs.getString("hospital_city");
				return result;
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				MYSQLcon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
		
	}

	public boolean DeleteHospital(HospitalDto hospitalDTO) {
		// TODO Auto-generated method stub
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("DELETE \n");
		sBuilder.append("FROM hospitals \n");
		sBuilder.append("WHERE hospital_id = ? \n");


		String queryString = sBuilder.toString();

		PreparedStatement pStatement;
		try {
			pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, hospitalDTO.getHospital_id());
			
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
	 
	 

//>>>>>>> branch 'master' of https://github.com/ANgajasinghe/PAF-Health_Care.git
}
