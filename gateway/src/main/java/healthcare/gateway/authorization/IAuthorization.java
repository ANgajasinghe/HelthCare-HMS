package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;


public interface IAuthorization {
	
	//All Doctor Client Call Start Here;
	public Response GetAllDoctors();
	public Response postDoc(DoctorDTO dto);
	public Response getSessionData(String hospitalID,String docID,String date);
	public Response getSessionDataById(int sessionId);
	
	public Response SelectDocById(String docID);
	
	
	//hospital
	public Response getHospitalNameByID(String hostID);
	
	


	
	//userProfile
	public Response InsertIntoUserProfile(UserDTO dto);
	
	
	
	//patient
	public Response InsertIntoPatient(PatientDto dto);

	
	
	//appointment Client
	public Response insertIntoAppoiment(AppoinmentDTO dto); 
	
	

}
