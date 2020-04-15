package healthcare.gateway;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class MyResource {
	
	 HttpCall mycall = new HttpCall();
	 
    @GET
    @Path("doc")
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
