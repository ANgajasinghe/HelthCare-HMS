package dto;

public class DocSessionDto {
	
	private Integer session_id;
	private Integer hospital_id;
	private Integer doc_id;
	private String available_date;
	private String start_time;
	private String end_time;
	private Integer isEveryday;
	private Integer isActive;
	private Integer patient_limit;
	public Integer getSession_id() {
		return session_id;
	}
	public void setSession_id(Integer session_id) {
		this.session_id = session_id;
	}
	public Integer getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	public Integer getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(Integer doc_id) {
		this.doc_id = doc_id;
	}
	public String getAvailable_date() {
		return available_date;
	}
	public void setAvailable_date(String available_date) {
		this.available_date = available_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getIsEveryday() {
		return isEveryday;
	}
	public void setIsEveryday(Integer isEveryday) {
		this.isEveryday = isEveryday;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getPatient_limit() {
		return patient_limit;
	}
	public void setPatient_limit(Integer patient_limit) {
		this.patient_limit = patient_limit;
	}
	
	
	
	

}
