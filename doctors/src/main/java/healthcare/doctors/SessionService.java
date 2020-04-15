package healthcare.doctors;



import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.DoctorDTO;
import healthcare.doctors.model.SessionModel;

@Path("session")
public class SessionService {
	
	SessionModel sModel = new SessionModel();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorDTO> getSessionData() {
		return sModel.getSessionData("102", "10003", "2020-04-18");
		
	}
	
}
