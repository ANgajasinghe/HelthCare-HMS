package dto;


public class PaymentDTO {

	private Integer payment_id;//primary key-payment
	
	private Integer doc_id; //doctors table
	private Integer hos_id; //hospitals table
	private Double amount;
	private Double doc_fee;
	private Double hos_fee;
	private Integer reference_No;
	private String date_time;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	
	public Integer getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(Integer doc_id) {
		this.doc_id = doc_id;
	}
	
	public Integer getHos_id() {
		return hos_id;
	}

	public void setHos_id(Integer hos_id) {
		this.hos_id = hos_id;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getDoc_fee() {
		return doc_fee;
	}

	public void setDoc_fee(Double doc_fee) {
		this.doc_fee = doc_fee;
	}
	
	public Double getHos_fee() {
		return hos_fee;
	}

	public void setHos_fee(Double hos_fee) {
		this.hos_fee = hos_fee;
	}

	public Integer getReference_No() {
		return reference_No;
	}

	public void setReference_No(Integer reference_No) {
		this.reference_No = reference_No;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
}


//IT18073256
//Dilshan K.K.D.N.
