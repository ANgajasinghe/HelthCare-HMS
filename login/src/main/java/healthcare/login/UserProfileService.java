package healthcare.login;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import loginDTO.UserDTO;

@Path("user")
public class UserProfileService {
	
	//how to redirect 
		@Context
    	private UriInfo uriInfo;
		
		private String pathval = "http://192.168.1.100:8080/gateway/webapi/api/doc";
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response  getIt() {
	        //return "Welcome to user service only authorize people have access to this";
	 		
	 		URI uri = null;
			try {
				uri = new URI(pathval);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	 		return Response.temporaryRedirect(uri).build();
	    }
	 	
	 	@POST
	 	@Path("register")
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void RegisterUser(UserDTO userDTO) {
	 		System.out.println(userDTO.getUser_email());
	 	}
	 	

}
