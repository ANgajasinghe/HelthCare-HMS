package healthcare.gateway.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import healthcare.gateway.auth.AuthFilter;


@Path("login")
public class LoginService {
	
	LoginClient cLoginClient = new LoginClient();
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTokenString(@QueryParam("user") String username, 
			@QueryParam("pwd") String password) { 
		System.out.println(AuthFilter.CurrentAuth);
    	 try {
			return cLoginClient.loginTokenApiCaller(username,password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
	
}
