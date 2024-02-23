package com.persondata.dto;

public class SignUp {
	private Integer userId;
    private String email;
    private String password;
	private String cpassword;
	public SignUp() {
	}
	public SignUp(Integer userId, String email, String password, String cpassword) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "SignUp [userId=" + userId + ", email=" + email + ", password=" + password + ", cpassword=" + cpassword
				+ "]";
	}
}
