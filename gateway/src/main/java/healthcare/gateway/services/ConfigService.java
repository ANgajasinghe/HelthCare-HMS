package healthcare.gateway.services;

import healthcare.gateway.auth.AuthFilter;
import healthcare.gateway.authorization.AdminAuth;
import healthcare.gateway.authorization.DefultAuth;
import healthcare.gateway.authorization.DoctorAuth;
import healthcare.gateway.authorization.IAuthorization;
import healthcare.gateway.authorization.PatientAuth;

public class ConfigService {
	protected String currentUser;
	protected String currentUserID = AuthFilter.CurrentAuthUserId;
	protected IAuthorization iAuthorization;
	
	protected void SetAuthorization() {
		currentUser = AuthFilter.CurrentAuth;
		switch (currentUser) {
		case "admin":
			iAuthorization = new AdminAuth();
			break;
		case "doctor":
			iAuthorization = new DoctorAuth();
			break;
		case "patient":
			iAuthorization = new PatientAuth();
			break;
		default:
			iAuthorization = new DefultAuth();
			break;
		}
	}
}
