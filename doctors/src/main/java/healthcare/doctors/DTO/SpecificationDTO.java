package healthcare.doctors.DTO;

public class SpecificationDTO {
	
	public final static String TABE_NAME = "doc_specification";
	public final static String specification_id  = "specification_id";
	public final static String specification_name  = "specification_name";
	public final static String specification_dis  = "specification_dis";
	
	private int SPECIFICATION_ID;
	private String SPECIFICATION_NAME;
	private String SPECIFICATION_DIS;
	
	public int getSPECIFICATION_ID() {
		return SPECIFICATION_ID;
	}
	public void setSPECIFICATION_ID(int sPECIFICATION_ID) {
		SPECIFICATION_ID = sPECIFICATION_ID;
	}
	public String getSPECIFICATION_NAME() {
		return SPECIFICATION_NAME;
	}
	public void setSPECIFICATION_NAME(String sPECIFICATION_NAME) {
		SPECIFICATION_NAME = sPECIFICATION_NAME;
	}
	public String getSPECIFICATION_DIS() {
		return SPECIFICATION_DIS;
	}
	public void setSPECIFICATION_DIS(String sPECIFICATION_DIS) {
		SPECIFICATION_DIS = sPECIFICATION_DIS;
	}
	
	
	
	
	
}
