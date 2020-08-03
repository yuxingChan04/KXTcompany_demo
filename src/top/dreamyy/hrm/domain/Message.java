package top.dreamyy.hrm.domain;

import java.io.Serializable;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	
	private Integer id;
	private String companyname;
	private String customname;
	private String phone;
	private String email;
	private String qq;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
			

}
