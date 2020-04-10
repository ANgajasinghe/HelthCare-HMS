package healthcare.doctors.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import healthcare.doctors.DTO.DoctorDTO;
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

	


	
	

}
