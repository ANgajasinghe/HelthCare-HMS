package healthcare.appointment;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	//@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO) {
		return appm.InsertIntoAppoinment(appoinmentDTO);
	}
	
	

}
