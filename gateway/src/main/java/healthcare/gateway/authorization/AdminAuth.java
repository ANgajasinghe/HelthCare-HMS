package healthcare.gateway.authorization;


import javax.ws.rs.core.Response;

import dto.DoctorDTO;
import healthcare.gateway.client.DoctorClient;
import healthcare.gateway.client.HospitalClient;


public class AdminAuth implements IAuthorization {

	//Init();
	DoctorClient doctorClient = new DoctorClient();
	HospitalClient hospitalClient = new HospitalClient();
	
	
	
	
	@Override
	public Response GetAllDoctors() {
		// TODO Auto-generated method stub
		return doctorClient.GetAllDoctors();
	}


	@Override
	public Response SelectDocById(String docID) {
		 System.out.println("Testing abcd");
		return doctorClient.SelectDocById(docID);
	}
	
	@Override
	public Response postDoc(DoctorDTO dto) {
		// TODO Auto-generated method stub
		return doctorClient.postDoc(dto);
	}

	//session client is here
	@Override
	public Response getSessionData(String hospitalID, String docID, String date) {
		return doctorClient.getSessionData(hospitalID, docID, date);
	}
	@Override
	public Response getSessionDataById(int sessionId) {
		return doctorClient.getSessionDataById(sessionId);
		
	}
	@Override
	public Response getHospitalNameByID(String hostID) {
		return hospitalClient.getHospitalNameByID(hostID); 
		
	}


	
	
	//
	
	@Override
	public void name() {
		// TODO Auto-generated method stub
		
	}

}
