package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import healthcare.gateway.client.DoctorClient;

public class DefultAuth implements IAuthorization {

	@Override
	public Response GetAllDoctors() {
		
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}

}
