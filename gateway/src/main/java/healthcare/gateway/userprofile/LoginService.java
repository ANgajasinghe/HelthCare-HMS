package healthcare.gateway.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import healthcare.gateway.auth.AuthFilter;
import utility.GMessage;


@Path("login")
public class LoginService {
	
	
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTokenString(@QueryParam("user") String username, 
			@QueryParam("pwd") String password) { 
		LoginClient cLoginClient = new LoginClient();
		System.out.println(AuthFilter.CurrentAuth);
    	 try {
			return cLoginClient.loginTokenApiCaller(username,password);
		} catch (Exception e) {
			return GMessage.wrongPwd;
		}
    }
	
}
