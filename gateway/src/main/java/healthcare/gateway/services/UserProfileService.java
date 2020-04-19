package healthcare.gateway.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.UserDTO;

@Path("user")
public class UserProfileService extends ConfigService {
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InsertIntoUserProfile(UserDTO dto) {
		this.SetAuthorization();
		return this.iAuthorization.InsertIntoUserProfile(dto);
	}
	
	@DELETE
	@Path("logout")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteToken() {
		this.SetAuthorization();
		return this.iAuthorization.deleteToken();
	}
	
}
