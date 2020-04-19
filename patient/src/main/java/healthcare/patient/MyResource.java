package healthcare.patient;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PatientDto;
import model.PatientModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("patient")
public class MyResource {

    PatientModel repo = new PatientModel();
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public PatientDto insertIntoPatient(PatientDto dto) {
    	if(repo.insertIntoPatient(dto)) {
    	return dto;
    }else {
    	return dto;
    }
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PatientDto> getPatients() {
		return repo.getPatients();
	}
	
	@GET
	@Path("patient/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PatientDto getpatient(@PathParam("id") String id) {
		return repo.getPatient(id);
	}
	
	
	@PUT
	@Path("patiendup")
	@Consumes(MediaType.APPLICATION_JSON)
	public PatientDto updateAlien(PatientDto a1) {
		repo.update(a1);
		System.out.println(a1);
		return a1;
	}
	
	@DELETE
	@Path("delete/{NIC}")
	@Consumes(MediaType.APPLICATION_JSON)
	public PatientDto deleteAlien(@PathParam("NIC") String NIC) {
		PatientDto a = repo.getPatient(NIC);

		if (a.getNIC() != null) {
			repo.delete(NIC);

		}
		return a;
	}
    
}
