package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

import healthcare.gatewayDTO.DoctorDTO;

public class DoctorAuthPatient implements DoctorAuth {

	DoctorClient client = new DoctorClient();

	@Override
	public Response getDocSpecData() {
		return client.getDocSpecData();

	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		return client.postDoc(dto);
	}

}
