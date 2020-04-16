package healthcare.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import dto.DoctorDTO;
import healthcare.gateway.client.DoctorClient;


@Path("doc")
public class DoctorService extends ConfigService{


	//DoctorAuth doctorService;
	
	@GET
	public Response getDocSpec() {
		this.SetAuthorization();
		Response response = iAuthorization.GetAllDoctors();
		return response;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response SelectDocById(@PathParam("id") String id) {
		this.SetAuthorization();
		return iAuthorization.SelectDocById(id);
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDoc(DoctorDTO dto) {
		this.SetAuthorization();
		return iAuthorization.postDoc(dto);
	}
	
	@GET
	@Path("session")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionData(
			@QueryParam("hospital_id") String hospitalID,
			@QueryParam("doc_id") String docID,
			@QueryParam("date")String date
			){
		this.SetAuthorization();
		return iAuthorization.getSessionData(hospitalID, docID, date);
	}
	
	@GET
	@Path("session/id")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionDataById(@QueryParam("session_id") int sessionId) {
		this.SetAuthorization();
		return iAuthorization.getSessionDataById(sessionId);
		//DoctorClient dClient = new DoctorClient();
		//return dClient.GET_SESSION_DATA_FOR_APPOINMENT_SERVICE(sessionId);
	}
	
	
	

	
	

	
	
}
