package healthcare.gateway.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import healthcare.gateway.auth.AuthFilter;

@Path("appointment")
public class AppointmentService extends ConfigService {
	
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentData(){
		SetAuthorization();
		return iAuthorization.getAppointmentData();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentByUserID() {
		SetAuthorization();
		String userId = AuthFilter.CurrentAuthUserId;
		System.out.println("Calling" + userId);
		return iAuthorization.getAppointmentByUserID(userId);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaymentPendingList(@PathParam("id") int id){
		SetAuthorization();
		return iAuthorization.getPaymentPendingList(id);
		
	}
	
	@GET
	@Path("session/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response SelecthospitalName(@PathParam("id") String id) {
		SetAuthorization();
		return iAuthorization.SelecthospitalName(id);
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		SetAuthorization();
		return iAuthorization.insertIntoAppoiment(dto);
		
	}

	
	
	
	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
		SetAuthorization();
		return iAuthorization.UpdateAppoinment(appoinmentDTO);
		
	}
	
	@DELETE
	@Path("del/{id}")
	public Response DeleteAppoinment(@PathParam("id") int id) {
		SetAuthorization();
		return iAuthorization.DeleteAppoinment(id);
	    	
	}
	
	

}
