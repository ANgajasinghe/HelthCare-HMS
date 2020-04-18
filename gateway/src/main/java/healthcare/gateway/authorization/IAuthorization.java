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
	public Response UpdateDoc(String docID, DoctorDTO dto); 
	
	public Response SelectDocById(String docID);
	public Response DeleteDocAll(int docID);
	
	
	public Response insertIntoSession(DoctorDTO doctorDTO);
	public Response UpdateSession(int sessionId, DoctorDTO dto);
	public Response deleteSession(int sessionId);
	
	//hospital
	public Response getHospitalNameByID(String hostID);
	
	


	
	//userProfile
	public Response InsertIntoUserProfile(UserDTO dto);
	
	
	
	//patient
	public Response InsertIntoPatient(PatientDto dto);

	
	
	//appointment Client
	public Response insertIntoAppoiment(AppoinmentDTO dto);
	public Response getAppointmentByUserID(String userId);

	
	
	
	
	

}
