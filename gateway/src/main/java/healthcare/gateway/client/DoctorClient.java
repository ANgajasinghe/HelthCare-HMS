package healthcare.gateway.client;

import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import utility.IpMapperDTO;
import utility.IpMapperModel;

public class DoctorClient {

	String API;
	Client client = ClientBuilder.newClient();

	public DoctorClient() {
		super();
		IpMapperModel iModel = new IpMapperModel();
		IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();
		API = iMapperDTO.getDocIP();
	}

	public static Response UnAuthorize() {
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

	public final Response GetAllDoctors() {
		WebTarget service = client.target(API).path("doc");
		try {
			// DoctorDTO dto =
			// service.request(MediaType.APPLICATION_JSON).get(DoctorDTO.class);
			// System.out.println(dto.getDoc_city());
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

	// session Client methods is here

	public final Response getSessionData(String hospitalID, String docID, String date) {
		WebTarget service = client.target(API).path("session").queryParam("hospital_id", hospitalID)
				.queryParam("doc_id", docID).queryParam("date", date);
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public final Response getSessionDataById(int sessionId) {
		WebTarget service = client.target(API).path("session").path(String.valueOf(sessionId));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

}
