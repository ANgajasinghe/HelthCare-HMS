package healthcare.hospital;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.crypto.provider.HmacMD5;
import model.HospitalModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("hospital")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	HospitalModel hmodel= new HospitalModel();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public String getIt(@QueryParam("id") String userID) {
        return hmodel.getHospitalIdByuserId(userID);
    }
}
