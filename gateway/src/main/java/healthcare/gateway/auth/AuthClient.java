package healthcare.gateway.auth;


import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import utility.IpMapperDTO;
import utility.IpMapperModel;

public class AuthClient {
	
	String API;
	String HospitalIP;
	Client client = ClientBuilder.newClient();

	public AuthClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getUserIP();
		HospitalIP = iMapperDTO.getHospitalIP();
	}	
	
	public final String AuthChecker(String authToken) {
		System.out.println("login:- " + API);
		WebTarget service = client.target(API).path("check").queryParam("token", authToken);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println("responce:-"+response);
			return response;
		} catch (ProcessingException e) {
			 Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			 return null;
		}
	}
	
	public final String GetHospitalId(String userId) {
		WebTarget service = client.target(HospitalIP).path("user").queryParam("id", userId);
		try {
			String response = service.request(MediaType.APPLICATION_JSON).get(String.class);
			return response;
		} catch (ProcessingException e) {
			 Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			 return null;
		}
	}
	
	
}
