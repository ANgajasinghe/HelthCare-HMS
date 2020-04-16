package healthcare.gateway.client;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
 
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import utility.IpMapperDTO;
import utility.IpMapperModel;

public class HospitalClient {
	String API;
	Client client = ClientBuilder.newClient();
	
	public HospitalClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getHospitalIP();
	}
	
	public final Response getHospitalNameByID(String hospitalId) {
		
		WebTarget service = client.target(API).path(hospitalId);
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	
	
}
