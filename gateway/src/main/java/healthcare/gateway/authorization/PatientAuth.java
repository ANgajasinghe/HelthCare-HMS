package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.PaymentDTO;
import dto.UserDTO;
import healthcare.gateway.auth.AuthFilter;
import healthcare.gateway.client.DoctorClient;

public class PatientAuth extends ConfigAuth implements IAuthorization {

	@Override
	public Response GetAllDoctors(String ALL) {
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response getSessionData(String hospitalID, String docID, String date,String type) {
		return doctorClient.getSessionData(hospitalID, docID, date,type);
	}

	@Override
	public Response getSessionDataById(int sessionId) {
		return doctorClient.getSessionDataById(sessionId);
	}

	@Override
	public Response SelectDocById(String docID) {
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response getHospitalNameByID(String hostID) {
		return DoctorClient.UnAuthorize();
	}
	public Response DeleteDocAll(int docID) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}
	@Override
	public Response UpdateDoc(String docID, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
	}


	@Override
	public Response InsertIntoUserProfile(UserDTO dto) {
		return DoctorClient.UnAuthorize();
	}

	
	
	// patient
	@Override
	public Response InsertIntoPatient(PatientDto dto) {
		return patientClient.InsertIntoPatient(dto);
	}

	
	
	// appointment
	@Override
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		return appointmentClient.insertIntoAppoiment(dto);
	}
	
	@Override
	public Response getAppointmentByUserID(String userId) {
		return appointmentClient.getAppointmentByUserID(userId);
	}
	
	@Override
	public Response UpdateSession(int sessionId, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Response deleteSession(int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Response insertIntoSession(DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAppointmentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getPaymentPendingList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response SelecthospitalName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response UpdateAppoinment(AppoinmentDTO appoinmentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response DeleteAppoinment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getPaymentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response InsertIntoPayments(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response UpdatePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response DeletePayment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteToken() {
		return userProfileClient.deleteToken(AuthFilter.Token);
	}
	
	

}
