package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

import healthcare.gatewayDTO.DoctorDTO;

public interface DoctorAuth {
	
	DoctorClient client = new DoctorClient();
	public Response getDocSpecData();
	public Response postDoc(DoctorDTO dto);
	

}
