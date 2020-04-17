package healthcare.gateway.authorization;

import healthcare.gateway.client.AppointmentClient;
import healthcare.gateway.client.DoctorClient;
import healthcare.gateway.client.HospitalClient;
import healthcare.gateway.client.PatientClient;
import healthcare.gateway.client.UserProfileClient;

public class ConfigAuth {
	public DoctorClient doctorClient = new DoctorClient();
	public HospitalClient hospitalClient = new HospitalClient();
	public UserProfileClient userProfileClient = new UserProfileClient();
	public PatientClient patientClient =  new PatientClient();
	public AppointmentClient appointmentClient = new AppointmentClient();
}
