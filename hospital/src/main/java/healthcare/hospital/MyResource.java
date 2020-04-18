package healthcare.hospital;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
//import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.sun.crypto.provider.HmacMD5;

import dto.HospitalDto;
import model.HospitalModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("hospital")
public class MyResource {
	
	HospitalModel hmodel= new HospitalModel();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HospitalDto> getAllHospitals(){
    	return hmodel.getAllHospitals();
    	
    }
	
    	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public String getIt(@QueryParam("id") String userID) {
        return hmodel.getHospitalIdByuserId(userID);
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getHospitalNameByID(@PathParam("id") String id) {
		return hmodel.getHospitalNameByID(id);
    }
    
    
    
    
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIntoHospital(HospitalDto hospitalDTOs) {
		return hmodel.insertIntoHospital(hospitalDTOs);
	}
    
    
    
    
	@PUT
	@Path("up/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HospitalDto UpdateHospital(HospitalDto hospitalDTO) {
		if(hmodel.UpdateHospital(hospitalDTO)) {
			System.out.println("Update sucsses");
			System.out.println( hospitalDTO);
			return hospitalDTO;
		}else {
			System.out.println("Not Update");
		 return hospitalDTO;
		}
	}
    
    
    
	

	
	
    @DELETE
	@Path("del/{id}")
	public Response DeleteHospital(@PathParam("id") int id,HospitalDto hospitalDTO) {
		hospitalDTO.setHospital_id(id);
	    if (hmodel.DeleteHospital(hospitalDTO)) {
	    	System.out.println("Delete sucsses");
	        return Response.ok().build();
	    } else {
	        return Response.notModified().build();
	    }
	}
    
}
