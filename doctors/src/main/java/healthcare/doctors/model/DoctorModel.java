package healthcare.doctors.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import healthcare.doctors.DTO.SpecificationDTO;
import utility.ConnectionBuilder;
import utility.Messages;


public class DoctorModel implements IDataModel {
	
	private final static ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final static Connection MYSQLcon  = cBuilder.MYSQLConnection();
	
	@Override
	public boolean connectionChecker() {
		
		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<SpecificationDTO> getSepecificationAllData() 
	{
		
		List<SpecificationDTO> specificationDTOliList = new ArrayList<SpecificationDTO>();
		
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
				Statement stmt = MYSQLcon.createStatement();
				ResultSet rs = stmt.executeQuery(qurtString);
				
				while (rs.next()) {
					SpecificationDTO dto = new SpecificationDTO();
					
					dto.setSPECIFICATION_ID(rs.getInt(SpecificationDTO.specification_id));
					dto.setSPECIFICATION_NAME(rs.getString(SpecificationDTO.specification_name));
					dto.setSPECIFICATION_DIS((rs.getString(SpecificationDTO.specification_dis) != null) ? 
							rs.getString(SpecificationDTO.specification_dis) : Messages.NODATA);
					specificationDTOliList.add(dto);	
				}
				
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
