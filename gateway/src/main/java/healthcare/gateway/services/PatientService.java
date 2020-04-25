package healthcare.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.PatientDto;
import dto.UserDTO;

@Path("patient")
public class PatientService extends ConfigService {
	

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InsertIntoPatient(PatientDto dto) {
		
		System.out.println(dto.getUserProfile());
		
		this.SetAuthorization();
		return this.iAuthorization.InsertIntoPatient(dto);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientDto name() {
		UserDTO dto = new UserDTO();
		dto.setUser_id(100);
		dto.setUsername("nayanajith");
		dto.setUser_email("WWnayanajith@gmail.com");
		
		PatientDto dto2 = new PatientDto();
		
		//dto2.setFirst_name("nayanaith");
		dto2.setUserProfile(dto);
				
		return dto2;
	}

	
}
