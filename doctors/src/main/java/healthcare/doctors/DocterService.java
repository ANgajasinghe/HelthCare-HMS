package healthcare.doctors;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.DoctorDTO;
import healthcare.doctors.model.DoctorModel;
import healthcare.doctors.model.IDataModel;

@Path("doc")
public class DocterService {

	private IDataModel dm = new DoctorModel();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorDTO> getAllDoctors() {
		return dm.getAllDoctors();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DoctorDTO SelectDocById(@PathParam("id") String id) {
		System.out.println("calling+"+id);
		return dm.SelectDocById(id);
	}
	
	@GET
	@Path("spec")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorDTO> getSpecications() {
		return dm.getSepecificationAllData();
	}
	
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertIntoDoctors(DoctorDTO doctorDTOs) {
		return dm.insertIntoDoctors(doctorDTOs);
	}
	
	
	

}
