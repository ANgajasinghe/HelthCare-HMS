package healthcare.hospital;

import model.HospitalModel;

public class HospitalService<HospitalDto> {
	
	private HospitalModel hm = new HospitalModel();
	
	public String getHospitalIdByuserId() {
		return hm.getHospitalIdByuserId(null);
	}

}
