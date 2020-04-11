package healthcare.gateway.doctor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("doc")
public class DoctorService {
	
	DoctorClient client = new DoctorClient();
	
	@GET
	public Response getDocSpec() {
		System.out.println("calling");
		return client.getDocSpecData();
	}
}
