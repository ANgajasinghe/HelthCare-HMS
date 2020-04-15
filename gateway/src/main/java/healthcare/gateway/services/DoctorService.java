package healthcare.gateway.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	String currentUserID;
	//DoctorAuth doctorService;
	
	IAuthorization iAuthorization;
	
	
//	private void setInterfaces() {
//		currentUser = AuthFilter.CurrentAuth;
//		switch (currentUser) {
//		case "admin":
//			doctorService = new DoctorAuthAdmin();
//			break;
//		case "doctor":
//			doctorService = new DoctorAuthDoctor();
//			break;
//		case "patient":
//			doctorService = new DoctorAuthPatient();
//			break;
//		default:
//			doctorService = new DoctorAuthDefult();
//			break;
//		}
//
//	}
	
	private void SetAuthorization() {
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
	
	@POST
	@Path("add")
	public Response postDoc(DoctorDTO dto) {
		SetAuthorization();
		return iAuthorization.postDoc(dto);
	}

	
	
}
