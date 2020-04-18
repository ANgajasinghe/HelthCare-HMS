package healthcare.gateway.client;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.DoctorDTO;
import utility.IpMapperDTO;
import utility.IpMapperModel;
import utility.Rcode;

public class DoctorClient {

	String API;
	Client client = ClientBuilder.newClient();
	HospitalClient hsClient = new HospitalClient();
	IpMapperModel iModel = new IpMapperModel();
	IpMapperDTO iMapperDTO = iModel.getIpMapperDTO();

	public DoctorClient() {
		super();
		API = iMapperDTO.getDocIP();
	}

	private List<DoctorDTO> deserializeList(String jString) {
		Type listType = new TypeToken<ArrayList<DoctorDTO>>() {
		}.getType();
		List<DoctorDTO> list = new Gson().fromJson(jString, listType);
		return list;
	}

	private Response buildResponse(Object object) {
		return Response.status(Response.Status.OK).entity(object).type(MediaType.APPLICATION_JSON).build();
	}

	public static Response UnAuthorize() {
		return Response.status(Response.Status.UNAUTHORIZED).entity("User Cannot Access the resource").build();
	}

	public final Response GetAllDoctors() {
		WebTarget service = client.target(API).path("doc");
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	public final Response SelectDocById(String docID) {

		List<String> hospitalNameList = new ArrayList<String>();

		System.out.println("SelectDocById is calling");
		WebTarget service = client.target(API).path("doc").path(docID);
		try {
			DoctorDTO docData = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).get().readEntity(DoctorDTO.class);

			// Intercommunication
			for (String string : docData.getHospilalIDList()) {
				hospitalNameList.add(hsClient.getHospitalNameByID(string).readEntity(String.class));
			}
			docData.setHospilalIDList(null);
			docData.setHospitalNameList(hospitalNameList);

			return this.buildResponse(docData);

		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException e) {
			return Rcode.No_content("Please change your searching values");
		}

	}

	public final Response postDoc(DoctorDTO dto) {
		WebTarget service = client.target(API).path("doc").path("add");
		try {
			Response response = service.request().header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP())
					.post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public final Response DeleteDocAll(int docID) {
		WebTarget service = client.target(API).path("doc").path("delete").path(String.valueOf(docID));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).delete();
			if (response.getStatus() == Rcode.No_Content) {
				return Rcode.No_content("invalid session id");
			}
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public Response UpdateDoc(String docID, DoctorDTO dto) {
		WebTarget service = client.target(API).path("doc").path("update").path(String.valueOf(docID));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).put(Entity.json(dto));
//			if (response.getStatus() == Rcode.No_Content) {
//				 return Rcode.No_content("invalid session id");
//			}
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
			String response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).get().readEntity(String.class);

			List<DoctorDTO> sessionList = this.deserializeList(response);
			for (DoctorDTO doctorDTO : sessionList) {
				String hospitalId = String.valueOf(doctorDTO.getHospital_id());
				doctorDTO.setHospital_name(hsClient.getHospitalNameByID(hospitalId).readEntity(String.class));
				doctorDTO.setHospital_id(null);
			}
			return this.buildResponse(sessionList);

		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException e) {
			return Rcode.No_content("Please change your searching values");
		}

	}

	public final Response getSessionDataById(int sessionId) {
		WebTarget service = client.target(API).path("session").path(String.valueOf(sessionId));
		try {
			// Inbound request:- when you are receiving the response on the client side
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).get();

			DoctorDTO sessionDto = response.readEntity(DoctorDTO.class);

			int doctor_id = sessionDto.getDoc_id();

			// get Outbound request :- when you are sending a response from the server
			Object doctorObject = this.SelectDocById(String.valueOf(doctor_id)).getEntity();

			DoctorDTO doctor = (DoctorDTO) doctorObject;

			// remove data from doctor
			doctor.setDoc_id(null);
			sessionDto.setDocObj(doctor);

			return buildResponse(sessionDto);

		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException e) {
			return Rcode.No_content("invalid session id");
		}

	}

	public Response insertIntoSession(DoctorDTO doctorDTO) {

		WebTarget service = client.target(API).path("session").path("add");
		try {
			Response response = service.request().header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP())
					.post(Entity.json(doctorDTO));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public Response UpdateSession(int sessionId, DoctorDTO dto) {
		WebTarget service = client.target(API).path("session").path("update").path(String.valueOf(sessionId));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).put(Entity.json(dto));
//			if (response.getStatus() == Rcode.No_Content) {
//				 return Rcode.No_content("invalid session id");
//			}
			return response;

		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return Rcode.No_content("invalid session id");
		}
	}

	public Response deleteSession(int sessionId) {
		WebTarget service = client.target(API).path("session").path("delete").path(String.valueOf(sessionId));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).delete();
			if (response.getStatus() == Rcode.No_Content) {
				return Rcode.No_content("invalid session id");
			}
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public final Response GET_SESSION_DATA_FOR_APPOINMENT_SERVICE(int sessionId) {
		WebTarget service = client.target(API).path("session").path(String.valueOf(sessionId));
		try {
			Response response = service.request(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ALLOW, iMapperDTO.getGatewayIP()).get();
			if (response.getStatus() == Rcode.No_Content) {
				return Rcode.No_content("invalid session id");
			}
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
