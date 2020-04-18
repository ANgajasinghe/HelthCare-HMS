package healthcare.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import healthcare.gateway.auth.AuthFilter;

@Path("appointment")
public class AppointmentService extends ConfigService {
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		System.out.println("calling");
		SetAuthorization();
		return iAuthorization.insertIntoAppoiment(dto);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentByUserID() {
		SetAuthorization();
		String userId = AuthFilter.CurrentAuthUserId;
		System.out.println("Calling" + userId);
		return iAuthorization.getAppointmentByUserID(userId);
	}

}
