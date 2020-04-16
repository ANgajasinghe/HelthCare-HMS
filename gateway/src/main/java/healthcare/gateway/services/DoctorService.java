package healthcare.gateway.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import healthcare.gateway.auth.AuthFilter;
import healthcare.gateway.authorization.AdminAuth;
import healthcare.gateway.authorization.DefultAuth;
import healthcare.gateway.authorization.DoctorAuth;
import healthcare.gateway.authorization.IAuthorization;
import healthcare.gateway.authorization.PatientAuth;


@Path("doc")
public class DoctorService {

	String currentUser;
	String currentUserID = AuthFilter.CurrentAuthUserId;
	//DoctorAuth doctorService;
	
	IAuthorization iAuthorization;
	
	protected void SetAuthorization() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "admin":
			iAuthorization = new AdminAuth();
			break;
		case "doctor":
			iAuthorization = new DoctorAuth();
			break;
		case "patient":
			iAuthorization = new PatientAuth();
			break;
		default:
			iAuthorization = new DefultAuth();
			break;
		}
	}

	@GET
	public Response getDocSpec() {
		SetAuthorization();
		System.out.println(currentUser);
		System.out.println("calling");
		Response response = iAuthorization.GetAllDoctors();
		return response;
	}
	
	@GET
	@Path("{id}")
	public Response SelectDocById(@PathParam("id") String id) {
		SetAuthorization();
		System.out.println(id);
		DoctorDTO a = iAuthorization.SelectDocById(id).readEntity(DoctorDTO.class);
		System.out.println(a);
		iAuthorization.getHospitalNameByID("100");
		return null;
	}
	
	@POST
	@Path("add")
	public Response postDoc(DoctorDTO dto) {
		SetAuthorization();
		return iAuthorization.postDoc(dto);
	}
	
	@GET
	@Path("session")
	public Response getSessionData(
			@QueryParam("hospital_id") String hospitalID,
			@QueryParam("doc_id") String docID,
			@QueryParam("date")String date
			){
		SetAuthorization();
		return iAuthorization.getSessionData(hospitalID, docID, date);
	}
	
	@GET
	@Path("session/{id}")
	public Response getSessionDataById(@PathParam("id") int sessionId) {
		SetAuthorization();
		return iAuthorization.getSessionDataById(sessionId);
	}
	
	
	

	
	

	
	
}
