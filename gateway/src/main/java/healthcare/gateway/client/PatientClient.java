package healthcare.gateway.client;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.PatientDto;
import dto.UserDTO;
import utility.GMessage;
import utility.IpMapperDTO;
import utility.IpMapperModel;
import utility.Rcode;

public class PatientClient {
	String API;
	Client client = ClientBuilder.newClient();
	
	
	public PatientClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getPatientIP();
	}

	public final Response InsertIntoPatient(PatientDto dto) {
		System.out.println("calling patirent insettion");
		UserProfileClient cUserProfileClient = new UserProfileClient();
		WebTarget service = client.target(API).path("add");
		try {
			UserDTO newUser = dto.getUserProfile();
					
			System.out.println("this is dto"+ newUser);
			
			String result = "false";
			
			try {
				result = cUserProfileClient.checkUsernameAndPassword(newUser).readEntity(String.class);
			} catch (NullPointerException e) {
				return Rcode.Invalide("Please Enter User Name Or Password first");
			}
			
			System.out.println(result);
			if (!Boolean.valueOf(result)) {
				
				System.out.println();
				Response response = service.request(MediaType.APPLICATION_JSON).post(Entity.json(dto));
				
				String patientId = response.readEntity(String.class);
				System.out.println(patientId);
				newUser.setUser_id(Integer.valueOf(patientId));
				newUser.setUser_role("patient");
				
				
				
				//Response userResponse = cUserProfileClient.InsertIntoUserProfile(newUser);
				//return userResponse;
				
				return this.InsertIntoUserProfile(newUser);
				
			}
			return Rcode.Invalide("Entered Username OR Password already taken");
			
			
			
		} catch (ProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	public final Response InsertIntoUserProfile(UserDTO dto) {
		System.out.println("calling");
		//String ABC = +GMessage.path("user");
		WebTarget service = client.target("http://192.168.1.100:8080/login/webapi/user").path("register");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
