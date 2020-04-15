package healthcare.gateway.doctor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import healthcare.gateway.auth.AuthFilter;
import healthcare.gateway.doctor.auth.DoctorAuth;
import healthcare.gateway.doctor.auth.DoctorAuthAdmin;
import healthcare.gateway.doctor.auth.DoctorAuthDefult;
import healthcare.gateway.doctor.auth.DoctorAuthDoctor;
import healthcare.gateway.doctor.auth.DoctorAuthPatient;
import healthcare.gatewayDTO.DoctorDTO;


@Path("doc")
public class DoctorService {

	String currentUser;
	DoctorAuth doctorService;
	
	private void setInterfaces() {
		System.out.println("calling");
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
		System.out.println(currentUser);
		System.out.println("calling");
		return doctorService.getDocSpecData();
	}
	
	@POST
	@Path("add")
	public Response postDoc(DoctorDTO dto) {
		setInterfaces();
		return doctorService.postDoc(dto);
	}

	
	
}
