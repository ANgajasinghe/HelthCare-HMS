package healthcare.hospital;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.HospitalDto;
import model.HospitalModel;

@Path("hos")
public class HospitalService {

	private HospitalModel hm = new HospitalModel();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HospitalDto> getAllDoctors() {
		return hm.getAllHospitals();
	}
	
	
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIntoHospital(HospitalDto hospitalDTOs) {
		return hm.insertIntoHospital(hospitalDTOs);
	}
	
	
	@PUT
	@Path("{hospital_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateHospital(@PathParam("hospital_id")int hospital_id,HospitalDto hospitalDTO) {
		hospitalDTO.setHospital_id(hospital_id);
		if(hm.UpdateHospital(hospitalDTO)) {
			return Response.ok().build();
		}else {
		return Response.notModified().build();
		}
	}
	
	
	@DELETE
	@Path("{hospital_id}")
	public Response DeleteHospital(@PathParam("hospital_id") int hospital_id,HospitalDto hospitalDTO) {
		hospitalDTO.setHospital_id(hospital_id);;
	    if (hm.DeleteHospital(hospitalDTO)) {
	        return Response.ok().build();
	    } else {
	        return Response.notModified().build();
	    }
	}

}
