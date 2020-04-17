package healthcare.patient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PatientDto;
import model.PatientModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("patient")
public class MyResource {

    PatientModel pmodel = new PatientModel();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String InsertIntoPatient(PatientDto dto) {
    	return pmodel.insertIntoPatient(dto);
    }
}
