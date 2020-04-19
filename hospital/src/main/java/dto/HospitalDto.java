package dto;

public class HospitalDto {

	//hospital user
	
	private Integer host_user_id;
	private String 	host_user_name;
	private Integer hospital_id;
	private String  hospital_name;
	private String hospital_address_no;
	private String hospital_address_lane1;
	private String hospital_address_lane2;
	private String hospital_address_lane3;
	private String hospital_city;
	private String tel;
	private String email;
	
	//Other attributes
	
	private String hospital_list;


	public Integer getHost_user_id() {
		return host_user_id;
	}
	
	public void setHost_user_id(Integer host_user_id) {
		this.host_user_id = host_user_id;
	}
	
	public String getHost_user_name() {
		return host_user_name;
	}
	
	public void setHost_user_name(String host_user_name) {
		this.host_user_name = host_user_name;
	}
	
	public Integer getHospital_id() {
		return hospital_id;
	}
	
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	} 
	
	public String getHospital_name() {
		return hospital_name;
	}
	
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	
	public String getHospital_address_no() {
		return hospital_address_no;
	}
	
	public void setHospital_address_no(String hospital_address_no) {
		this.hospital_address_no = hospital_address_no;
	}
	
	public String getHospital_address_lane1() {
		return hospital_address_lane1;
	}
	
	public void setHospital_address_lane1(String hospital_address_lane1) {
		this.hospital_address_lane1 = hospital_address_lane1;
	}
	
	public String getHospital_address_lane2() {
		return hospital_address_lane2;
	}
	
	public void setHospital_address_lane2(String hospital_address_lane2) {
		this.hospital_address_lane2 = hospital_address_lane2;
	}
	
	public String getHospital_address_lane3() {
		return hospital_address_lane3;
	}
	
	public void setHospital_address_lane3(String hospital_address_lane3) {
		this.hospital_address_lane3 = hospital_address_lane3;
	}
	
	public String getHospital_city() {
		return hospital_city;
	}
	
	public void setHospital_city(String hospital_city) {
		this.hospital_city = hospital_city;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHospital_list() {
		return hospital_list;
	}

	public void setHospital_list(String hospital_list) {
		this.hospital_list = hospital_list;
	}
	
	
}
