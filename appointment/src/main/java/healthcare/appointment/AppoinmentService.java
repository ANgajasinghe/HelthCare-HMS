package healthcare.appointment;

import java.util.List;

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

import model.AppointmentModel;


@Path("app")
public class AppoinmentService {
	
	private AppointmentModel appm = new AppointmentModel();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AppoinmentDTO> getAppointmentData(){
		return appm.getAppointmentData();
		
	}
	
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String SelecthospitalName(@PathParam("id") String id) {
		System.out.println("calling+"+id);
		return appm.SelecthospitalName(id);
	}
	
	
	@POST
	@Path("add")
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO) {
		System.out.println("calling service");
		return appm.InsertIntoAppoinment(appoinmentDTO);
	}
	
	
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateAppoinment(@PathParam("id")int id,AppoinmentDTO appoinmentDTO) {
		appoinmentDTO.setApp_patient_id(id);
		if(appm.UpdateAppoinment(appoinmentDTO)) {
			return Response.ok().build();
		}else {
		return Response.notModified().build();
		}
	}
	
	
	
	@DELETE
	@Path("{id}")
	public Response DeleteAppoinment(@PathParam("id") int id,AppoinmentDTO appoinmentDTO) {
		appoinmentDTO.setApp_patient_id(id);
	    if (appm.DeleteAppoinment(appoinmentDTO)) {
	        return Response.ok().build();
	    } else {
	        return Response.notModified().build();
	    }
	}
	
	

}
