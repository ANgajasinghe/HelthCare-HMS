package healthcare.gateway.doctor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import healthcare.gateway.auth.AuthFilter;
import healthcare.gateway.doctor.auth.DoctorAuth;
import healthcare.gateway.doctor.auth.DoctorAuthAdmin;
import healthcare.gateway.doctor.auth.DoctorAuthDefult;
import healthcare.gateway.doctor.auth.DoctorAuthDoctor;
import healthcare.gateway.doctor.auth.DoctorAuthPatient;


@Path("doc")
public class DoctorService {

	String currentUser;
	DoctorAuth doctorService;
	
	private void setInterfaces() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "admin":
			doctorService = new DoctorAuthAdmin();
			break;
		case "doctor":
			doctorService = new DoctorAuthDoctor();
			break;
		case "patient":
			doctorService = new DoctorAuthPatient();
			break;
		default:
			doctorService = new DoctorAuthDefult();
			break;
		}

	}

	@GET
	public Response getDocSpec() {
		setInterfaces();
		currentUser = AuthFilter.CurrentAuth;
		System.out.println(currentUser);
		System.out.println("calling");
		return doctorService.getDocSpecData();
	}

	
	
}
