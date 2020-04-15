package healthcare.gateway.userprofile;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import healthcare.gatewayDTO.IpMapperDTO;
import healthcare.gatewayDTO.IpMapperModel;


public class LoginClient {

	String API;
	
	public LoginClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getUserIP();
	}

	Client client = ClientBuilder.newClient();
	
	public final String loginTokenApiCaller(String username , String password ) {
		System.out.println(username + password);
		WebTarget service = client.target(API).path(username).path(password);
		try {
			String response = service.request(MediaType.TEXT_PLAIN).get(String.class);
			return response;
		} catch (ProcessingException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return API;
		
	}
	
	
}
