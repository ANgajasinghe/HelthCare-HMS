package healthcare.gateway.authorization;


import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;



public class AdminAuth extends ConfigAuth implements IAuthorization {

	//Init();
//	DoctorClient doctorClient = new DoctorClient();
//	HospitalClient hospitalClient = new HospitalClient();
//	UserProfileClient userProfileClient = new UserProfileClient();
//	PatientClient patientClient =  new PatientClient();
	
	
	
	
	@Override
	public Response GetAllDoctors(String ALL) {
		// TODO Auto-generated method stub
		return doctorClient.GetAllDoctors(ALL);
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
	
	@Override
	public Response DeleteDocAll(int docID) {
		// TODO Auto-generated method stub
		return doctorClient.DeleteDocAll(docID);
	}
	
	@Override
	public Response UpdateDoc(String docID, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return doctorClient.UpdateDoc( docID, dto);
	}

	//session client is here
	@Override
	public Response getSessionData(String hospitalID, String docID, String date,String type) {
		return doctorClient.getSessionData(hospitalID, docID, date, type);
	}
	@Override
	public Response getSessionDataById(int sessionId) {
		return doctorClient.getSessionDataById(sessionId);
		
	}
	
	@Override
	public Response insertIntoSession(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		return doctorClient.insertIntoSession(doctorDTO);
	}
	@Override
	public Response UpdateSession(int sessionId, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return doctorClient.UpdateSession(sessionId,dto);
	}
	
	@Override
	public Response deleteSession(int sessionId) {
		// TODO Auto-generated method stub
		return doctorClient.deleteSession(sessionId);
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
	
	@Override
	public Response getAppointmentByUserID(String userId) {
		return appointmentClient.getAppointmentByUserID(userId);
	}


	@Override
	public Response getAppointmentData() {
		// TODO Auto-generated method stub
		return appointmentClient.getAppointmentData();
	}


	@Override
	public Response getPaymentPendingList() {
		// TODO Auto-generated method stub
		return appointmentClient.getPaymentPendingList();
	}


	@Override
	public Response SelecthospitalName(String id) {
		// TODO Auto-generated method stub
		return appointmentClient. SelecthospitalName(id);
	}


	@Override
	public Response UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
		// TODO Auto-generated method stub
		return appointmentClient.UpdateAppoinment(appoinmentDTO);
	}


	@Override
	public Response DeleteAppoinment(int id) {
		// TODO Auto-generated method stub
		return appointmentClient.DeleteAppoinment(id);
	}
	
	
	

}
