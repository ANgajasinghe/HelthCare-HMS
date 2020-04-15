package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import healthcare.gateway.client.DoctorClient;

public class HospitalManagerAuth implements IAuthorization {
	
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
}
