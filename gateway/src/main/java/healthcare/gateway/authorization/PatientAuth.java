package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;
import healthcare.gateway.client.DoctorClient;


public class PatientAuth extends ConfigAuth implements IAuthorization {


	

	
	@Override
	public Response GetAllDoctors() {
		
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {

		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response getSessionData(String hospitalID, String docID, String date) {
		return doctorClient.getSessionData(hospitalID, docID, date);
	}

	@Override
	public Response getSessionDataById(int sessionId) {
		return doctorClient.getSessionDataById(sessionId);
		//return doctorClient.getSessionDataById(sessionId);	
	}

	@Override
	public Response SelectDocById(String docID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Response getHospitalNameByID(String hostID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Response InsertIntoUserProfile(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response InsertIntoPatient(PatientDto dto) {
		return patientClient.InsertIntoPatient(dto);
	}

}
