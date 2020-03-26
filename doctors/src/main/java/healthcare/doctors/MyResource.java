package healthcare.doctors;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import healthcare.doctors.DTO.SpecificationDTO;
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
    public List<SpecificationDTO> getItem() {
    	
    	return dm.getSepecificationAllData();
        
    }
}
