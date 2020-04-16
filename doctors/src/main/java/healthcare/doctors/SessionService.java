package healthcare.doctors;



import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dto.DoctorDTO;
import healthcare.doctors.model.SessionModel;

@Path("session")
public class SessionService {
	
	SessionModel sModel = new SessionModel();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoctorDTO> getSessionData(
			@QueryParam("hospital_id") String hospitalID,
			@QueryParam("doc_id") String docID,
			@QueryParam("date")String date
			) {
		return sModel.getSessionData(hospitalID,docID,date);
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DoctorDTO getSessionDataById(@PathParam("id") int sessionId) {
		return sModel.getSessionDataById(sessionId);
	}
	
}
