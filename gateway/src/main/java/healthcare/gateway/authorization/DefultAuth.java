package healthcare.gateway.authorization;

import javax.ws.rs.core.Response;

import dto.AppoinmentDTO;
import dto.DoctorDTO;
import dto.PatientDto;
import dto.UserDTO;
import healthcare.gateway.client.DoctorClient;
import utility.GMessage;
import utility.Rcode;

public class DefultAuth implements IAuthorization {

	DoctorClient doctorClient = new DoctorClient();
	
	@Override
	public Response GetAllDoctors(String ALL) {
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response postDoc(DoctorDTO dto) {
		return DoctorClient.UnAuthorize();
	}
	
	@Override
	public Response SelectDocById(String docID) {
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
	public Response getHospitalNameByID(String hostID) {
		return DoctorClient.UnAuthorize();
	}

	@Override
	public Response InsertIntoUserProfile(UserDTO dto) {
		return DoctorClient.UnAuthorize();
	}
	
	@Override
	public Response InsertIntoPatient(PatientDto dto) {
		return DoctorClient.UnAuthorize();

	}
	
	@Override
	public Response insertIntoAppoiment(AppoinmentDTO dto) {
		return Rcode.UNAUTHORIZED(GMessage.logfirt);
	}
	@Override
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
	public Response UpdateSession(int sessionId, DoctorDTO dto) {
		// TODO Auto-generated method stub
		return DoctorClient.UnAuthorize();
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
	public Response getAppointmentByUserID(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAppointmentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getPaymentPendingList() {
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
}
