package healthcare.gateway.client;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import dto.UserDTO;
import healthcare.gateway.auth.AuthFilter;
import utility.GMessage;
import utility.IpMapperDTO;
import utility.IpMapperModel;

public class UserProfileClient {

	String API;
	Client client = ClientBuilder.newClient();
	
	public UserProfileClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getUserIP();
		
	}
	
	public final Response InsertIntoUserProfile(UserDTO dto) {
		System.out.println("calling");
		API = API+GMessage.path("user");
		WebTarget service = client.target(API).path("register");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public Response checkUsernameAndPassword(UserDTO userDTO){
		API = API+GMessage.path("user");
		WebTarget service = client.target(API).path("check")
				.queryParam("username", userDTO.getUsername())
				.queryParam("email", userDTO.getUser_email());
		System.out.println("check user is calling ");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			
			return response;
		} catch (ProcessingException e) {
			System.out.println("erro in here");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			
		}
	}

	public Response deleteToken(String token) {
		System.out.println("CAlling " );
		WebTarget service = client.target(API).path("login").path("delete").queryParam("token", AuthFilter.CurrentAuthUserId);
		
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).delete();
			return response;
			
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			
		}
		
		
	}

}
