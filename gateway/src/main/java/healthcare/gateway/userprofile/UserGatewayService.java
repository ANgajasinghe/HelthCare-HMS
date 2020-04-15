package healthcare.gateway.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("api/user")
public class UserGatewayService {
	
	UserHttpCall mycall = new UserHttpCall();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocSpecification(@QueryParam("user") String username, 
			@QueryParam("pwd") String password) { 
    	 try {
    		
			return mycall.GetSpecdata(username,password);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
	
	@POST
	@Path("test")
	public String abc(String x) {
		return mycall.abcString(x);
	}
}
