package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import healthcare.gateway.client.DoctorClient;


public class PatientAuth implements IAuthorization {

	//Init();
	DoctorClient doctorClient = new DoctorClient();

	
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
		return DoctorClient.UnAuthorize();
		//return doctorClient.getSessionDataById(sessionId);
		
	}

}
