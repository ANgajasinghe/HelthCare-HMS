package healthcare.doctors;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import healthcare.doctors.DTO.DoctorDTO;
import healthcare.doctors.model.DoctorModel;
import healthcare.doctors.model.IDataModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private IDataModel dm = new DoctorModel(); 
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoctorDTO> getSpecications() {
    	
    	return dm.getSepecificationAllData();
        
    }
    
    @GET
    @Path("doc")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoctorDTO> getAllDoctors() {
    
    	return dm.getAllDoctors();
        
    }
    
    @POST
    @Path("doc/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String insertIntoDoctors(DoctorDTO doctorDTOs) {
    
    	return dm.insertIntoDoctors(doctorDTOs);
        
    }
    
    
//    
    
    
}
 