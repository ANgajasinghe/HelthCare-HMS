package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;
import healthcare.gateway.client.DoctorClient;


public class DoctorAuth implements IAuthorization {

	//Init();
	DoctorClient doctorClient = new DoctorClient();

	
	
	@Override
	public Response GetAllDoctors() {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response getSessionData(String hospitalID, String docID, String date) {
		// TODO Auto-generated method stub
		return doctorClient.getSessionData(hospitalID, docID, date);
	}

	@Override
	public Response getSessionDataById(int sessionId) {
		return DoctorClient.UnAuthorize();
		//return doctorClient.getSessionDataById(sessionId);
		
	}

	@Override
	public Response getHospitalNameByID(String hostID) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response SelectDocById(String docID) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response InsertIntoUserProfile(UserDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}
	@Override
	public Response InsertIntoPatient(PatientDto dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

	
//
	
	@Override
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}
	
	public Response DeleteDocAll(int docID) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}
	
	@Override
	public Response UpdateDoc(String docID, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}
	
	@Override
	public Response UpdateSession(int sessionId, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteSession(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response insertIntoSession(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Response getAppointmentByUserID(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
