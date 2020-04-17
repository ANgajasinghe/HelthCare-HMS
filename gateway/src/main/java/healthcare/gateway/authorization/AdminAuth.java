package healthcare.gateway.authorization;


import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;
import healthcare.gateway.client.DoctorClient;
import healthcare.gateway.client.HospitalClient;
import healthcare.gateway.client.PatientClient;
import healthcare.gateway.client.UserProfileClient;


public class AdminAuth extends ConfigAuth implements IAuthorization {

	//Init();
//	DoctorClient doctorClient = new DoctorClient();
//	HospitalClient hospitalClient = new HospitalClient();
//	UserProfileClient userProfileClient = new UserProfileClient();
//	PatientClient patientClient =  new PatientClient();
	
	
	
	
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
	
	
	//hospital
	@Override
	public Response getHospitalNameByID(String hostID) {
		return hospitalClient.getHospitalNameByID(hostID); 
		
	}
	
	//user profile
	@Override
	public Response InsertIntoUserProfile(UserDTO dto) {
		return userProfileClient.InsertIntoUserProfile(dto);
	}
	
	
	//patient
	@Override
	public Response InsertIntoPatient(PatientDto dto) {
		return patientClient.InsertIntoPatient(dto);
	}


	
	
	//Appointment
	@Override
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		return appointmentClient.insertIntoAppoiment(dto);
	}

}
