package healthcare.gateway.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("hospital")
public class HospitalService extends ConfigService {
	
	@GET
	@Path("{id}")
	public Response getHospitalNameByID(@PathParam("id") String hospitalId) {
		this.SetAuthorization();
		return iAuthorization.getHospitalNameByID(hospitalId);
	}
}
