package healthcare.gateway.doctor.auth;

import javax.ws.rs.core.Response;

import healthcare.gatewayDTO.DoctorDTO;

public class DoctorAuthDefult implements DoctorAuth {

	@Override
	public Response getDocSpecData() {
		return Response.status(Response.Status.UNAUTHORIZED)
		         .entity("User Cannot Access the resource")
		         .build();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		return Response.status(Response.Status.UNAUTHORIZED)
		         .entity("User Cannot Access the resource")
		         .build();
	}

	

}
