package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.DoctorDTO;


public interface IAuthorization {
	
	//All Doctor Client Call Start Here;
	public Response GetAllDoctors();
	public Response postDoc(DoctorDTO dto);
	
	
}
