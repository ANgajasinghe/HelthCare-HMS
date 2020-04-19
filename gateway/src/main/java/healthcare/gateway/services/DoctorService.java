package healthcare.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import dto.DoctorDTO;



@Path("doc")
public class DoctorService extends ConfigService{


	//DoctorAuth doctorService;
	
	@GET
	public Response GetAllDoctors(@QueryParam("type") String ALL) {
		this.SetAuthorization();
		Response response = iAuthorization.GetAllDoctors(ALL);
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
	

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteDocAll(@PathParam("id") String docID ) {
		System.out.println("Clling");
		this.SetAuthorization();
		return iAuthorization.DeleteDocAll(Integer.valueOf(docID));
	}
	
	@PUT
	@Path("update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateDoc(@PathParam("id") String docID , DoctorDTO dto) {
		this.SetAuthorization();
		return iAuthorization.UpdateDoc(docID, dto);
	}
	
	@GET
	@Path("session")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSessionData(
			@QueryParam("hospital_id") String hospitalID,
			@QueryParam("doc_id") String docID,
			@QueryParam("date")String date,
			@QueryParam("type")String type
			){
		this.SetAuthorization();
		return iAuthorization.getSessionData(hospitalID, docID, date,type);
	}
	
	@POST
	@Path("session/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertIntoDoctors(DoctorDTO doctorDTO) {
		this.SetAuthorization();
		return iAuthorization.insertIntoSession(doctorDTO);
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
	
	@PUT
	@Path("session/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateSession(@PathParam("id")int sessionId,DoctorDTO dto) {
		this.SetAuthorization();
		return iAuthorization.UpdateSession(sessionId, dto);
	}
	
	@DELETE
	@Path("session/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSession(@PathParam("id") int sessionId) {
		this.SetAuthorization();
		return iAuthorization.deleteSession(sessionId);
	}
	
	
	
	
	

	
	

	
	
}
