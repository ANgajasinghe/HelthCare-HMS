package healthcare.doctors.model;

import java.util.List;

import healthcare.doctors.DTO.SpecificationDTO;

public interface IDataModel {
	
	public boolean connectionChecker();
	public List<SpecificationDTO> getSepecificationAllData();
	
}
