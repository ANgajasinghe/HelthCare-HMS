package dto;

import java.util.Date;

public class AppoinmentDTO {
	
	private Integer app_doc_work_id;//primary key
	private Integer app_patient_id;//primary key
	private Integer app_patient_contact_no;
	
	private  Double app_price;
	
	
	private String app_patient_name;
	private String app_hospital_name;
	private String app_payment_status;
	
	private Date app_book_date;
	
	
	public Integer getApp_doc_work_id() {
		return app_doc_work_id;
	}

	public void setApp_doc_work_id(Integer app_doc_work_id) {
		this.app_doc_work_id = app_doc_work_id;
	}

	public Integer getApp_patient_id() {
		return app_patient_id;
	}

	public void setApp_patient_id(Integer app_patient_id) {
		this.app_patient_id = app_patient_id;
	}

	public Integer getApp_patient_contact_no() {
		return app_patient_contact_no;
	}

	public void setApp_patient_contact_no(Integer app_patient_contact_no) {
		this.app_patient_contact_no = app_patient_contact_no;
	}

	public String getApp_patient_name() {
		return app_patient_name;
	}

	public void setApp_patient_name(String app_patient_name) {
		this.app_patient_name = app_patient_name;
	}

	public String getApp_hospital_name() {
		return app_hospital_name;
	}

	public void setApp_hospital_name(String app_hospital_name) {
		this.app_hospital_name = app_hospital_name;
	}

	public String getApp_payment_status() {
		return app_payment_status;
	}

	public void setApp_payment_status(String app_payment_status) {
		this.app_payment_status = app_payment_status;
	}

	public Date getApp_book_date() {
		return app_book_date;
	}

	public void setApp_book_date(Date app_book_date) {
		this.app_book_date = app_book_date;
	}
	public Double getApp_price() {
		return app_price;
	}

	public void setApp_price(Double app_price) {
		this.app_price = app_price;
	}

	
	
	
	

}
