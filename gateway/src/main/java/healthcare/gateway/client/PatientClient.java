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
import utility.IpMapperDTO;
import utility.IpMapperModel;
import utility.Rcode;

public class PatientClient {
	String API;
	Client client = ClientBuilder.newClient();
	UserProfileClient cUserProfileClient = new UserProfileClient();
	
	public PatientClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getPatientIP();
	}

	public final Response InsertIntoPatient(PatientDto dto) {
		System.out.println("calling patirent insettion");
		WebTarget service = client.target(API).path("add");
		try {
			UserDTO newUser = dto.getUserProfile();

			String result = cUserProfileClient.checkUsernameAndPassword(newUser).readEntity(String.class);
			System.out.println(result);
			if (!Boolean.valueOf(result)) {
				Response response = service.request(MediaType.APPLICATION_JSON).post(Entity.json(dto));
				int patientId = response.readEntity(Integer.class);
				newUser.setUser_id(patientId);
				newUser.setUser_role("patient");
				Response userResponse = cUserProfileClient.InsertIntoUserProfile(newUser);
				return userResponse;
			}
			return Rcode.Invalide("Entered Username OR Password already taken");
			
			
			
		} catch (ProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	
}
