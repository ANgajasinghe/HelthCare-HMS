package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

public interface DoctorAuth {
	
	DoctorClient client = new DoctorClient();
	public Response getDocSpecData();

}
