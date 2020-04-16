package dto;

public class PatientDto {

	private Integer patient_idInteger;
	private String first_name;
	private String last_name;
	
	public Integer getPatient_idInteger() {
		return patient_idInteger;
	}
	public void setPatient_idInteger(Integer patient_idInteger) {
		this.patient_idInteger = patient_idInteger;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
