package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

import healthcare.gatewayDTO.DoctorDTO;

public class DoctorAuthDoctor implements DoctorAuth {

	DoctorClient client = new DoctorClient();

	@Override
	public Response getDocSpecData() {
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();

	}

	@Override
	public Response postDoc(DoctorDTO dto) {

		return client.postDoc(dto);
	}

}
