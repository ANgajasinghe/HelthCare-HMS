package healthcare.login;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("user")
public class UserProfileService {
	
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
	 	
	 	

}
