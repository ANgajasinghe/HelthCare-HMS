package healthcare.login;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



import dto.UserDTO;
import model.UserModel;
import utility.LMessage;

@Path("user")
public class UserProfileService {
	
	//how to redirect 
		@Context
    	private UriInfo uriInfo;
		
		private String pathval = "http://192.168.1.100:8080/gateway/webapi/api/doc";
		
		UserModel uModel = new UserModel();
	
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
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public String InsertIntoUserProfile(UserDTO userDTO) {
	 		if (uModel.InsertIntoUserProfile(userDTO)) { 
	 			return LMessage.regisrationSucess+" : for the username uses "
	 			+userDTO.getUsername() +" OR "
	 			+userDTO.getUser_email() +" And for the password use "+userDTO.getUser_password();
			} else {
				return LMessage.userTaken;
			}
	 	}
	 	
	 	@GET
	 	@Path("check")
	 	@Produces(MediaType.APPLICATION_JSON)
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	public boolean checkUsernameAndPassword(@QueryParam("username") String username,@QueryParam("email") String email) {
	 		
	 		UserDTO userDTO = new UserDTO();
	 		userDTO.setUsername(username);
	 		userDTO.setUser_email(email);
	 	
			return uModel.checkUsernameAndPassword(userDTO);
		}
	 	

}
