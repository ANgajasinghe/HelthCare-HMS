package healthcare.appointment;

import java.util.List;

//import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;

import model.AppointmentModel;


@Path("app")
public class AppoinmentService {
	
	private AppointmentModel appm = new AppointmentModel();
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AppoinmentDTO> getAppointmentData(){
		return appm.getAppointmentData();
		
	}
	
	@GET
	@Path("status")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AppoinmentDTO>  getPaymentPendingList(){
		return appm.getPaymentPendingList();
		
	}
	
	
	
	@GET
	@Path("session/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String SelecthospitalName(@PathParam("id") String id) {
		System.out.println("calling+"+id);
		return appm.SelecthospitalName(id);
	}
	
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AppoinmentDTO> getAppointmentByUser(@PathParam("id") int patientId){
		return appm.getAppointmentByUser(patientId);
		
	}
	
	
	
	
	@POST
	@Path("add")
	public String InsertIntoAppoinment(AppoinmentDTO appoinmentDTO) {
		System.out.println("calling service");
		return appm.InsertIntoAppoinment(appoinmentDTO);
	}
	
	
	
	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppoinmentDTO UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
		if(appm.UpdateAppoinment(appoinmentDTO)) {
			System.out.println("Update sucsses");
			System.out.println(appoinmentDTO);
			return appoinmentDTO;
		}else {
			System.out.println("Not Update");
			return appoinmentDTO;
		}
	}
	

	
	@DELETE
	@Path("del/{id}")
	public Response DeleteAppoinment(@PathParam("id") int id,AppoinmentDTO appoinmentDTO) {
		appoinmentDTO.setApp_patient_id(id);
	    if (appm.DeleteAppoinment(appoinmentDTO)) {
	    	System.out.println(appoinmentDTO);
	        return Response.ok().build();
	    } else {
	        return Response.notModified().build();
	    }
	}
	
	

}
