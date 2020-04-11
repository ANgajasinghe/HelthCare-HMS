package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

public class DoctorAuthAdmin implements DoctorAuth {

	DoctorClient client = new DoctorClient();
	@Override
	public Response getDocSpecData() {
		return client.getDocSpecData();	
	}

}
