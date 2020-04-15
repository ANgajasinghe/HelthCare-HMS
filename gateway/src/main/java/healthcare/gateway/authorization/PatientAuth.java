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

}
