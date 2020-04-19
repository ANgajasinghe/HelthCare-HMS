package helthcare.RMService;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {

	private int test_id;
	private String test_name;
	private String test_desc;
	private String test_cost;
	private String room_no;
	private String hospital_name;
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public String getTest_desc() {
		return test_desc;
	}
	public void setTest_desc(String test_desc) {
		this.test_desc = test_desc;
	}
	public String getTest_cost() {
		return test_cost;
	}
	public void setTest_cost(String test_cost) {
		this.test_cost = test_cost;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	@Override
	public String toString() {
		return "Test [test_id=" + test_id + ", test_name=" + test_name + ", test_desc=" + test_desc + ", test_cost="
				+ test_cost + ", room_no=" + room_no + ", hospital_name=" + hospital_name + "]";
	}
	
	
}
