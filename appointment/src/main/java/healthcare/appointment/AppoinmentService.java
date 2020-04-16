package healthcare.appointment;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	@POST
	@Path("add")
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO) {
		System.out.println("calling service");
		return appm.InsertIntoAppoinment(appoinmentDTO);
	}
	
//	@PUT
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public boolean UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
//		return appm.UpdateAppoinment(appoinmentDTO);
//	}
//	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String SelectDocById(@PathParam("id") String id) {
//		System.out.println("calling+"+id);
//		return appm.SelecthospitalName(id);
//	}
	
	

}
