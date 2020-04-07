package healthcare.gateway.userprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/user")
public class UserGatewayService {
	
	UserHttpCall mycall = new UserHttpCall();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDocSpecification() { 
    	 try {
    		
			return mycall.GetSpecdata();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
}
