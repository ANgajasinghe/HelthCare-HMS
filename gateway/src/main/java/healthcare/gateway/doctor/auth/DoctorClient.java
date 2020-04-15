package healthcare.gateway.doctor.auth;



import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import healthcare.gatewayDTO.DoctorDTO;
import healthcare.gatewayDTO.IpMapperDTO;
import healthcare.gatewayDTO.IpMapperModel;

public class DoctorClient {
	
	String API;
	Client client = ClientBuilder.newClient();

	public DoctorClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getDocIP();
	}
	
	public final Response getDocSpecData() {
		WebTarget service = client.target(API).path("doc");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	public final Response postDoc(DoctorDTO dto) {
		WebTarget service = client.target(API).path("doc").path("add");
		try {
			Response response = service.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
