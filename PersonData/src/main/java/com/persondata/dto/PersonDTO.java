package com.persondata.dto;

import java.util.Date;

public class PersonDTO {
	private Integer userId;
	private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String cpassword;
    private String gender;
    private Date dob;
    private Long phoneNumber;
    private Integer employeeId;
    private String state;
    private String city;
    private Long zipCode;
    private String designation;
    private Long pfno;
    private String department;
    private String directReportingManager;
    private String workLocation;
    private String addressLine1;
    private String addressLine2;
    private String qualification;
    private String country; 
    private String landmark; 
    private Integer companyId;
	public PersonDTO() {
	}
	public PersonDTO(Integer userId, String firstName, String lastName, String email, String password, String cpassword,
			String gender, Date dob, Long phoneNumber, Integer employeeId, String state, String city, Long zipCode,
			String designation, Long pfno, String department, String directReportingManager, String workLocation,
			String addressLine1, String addressLine2, String qualification, String country, String landmark,
			Integer companyId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.gender = gender;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.employeeId = employeeId;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.designation = designation;
		this.pfno = pfno;
		this.department = department;
		this.directReportingManager = directReportingManager;
		this.workLocation = workLocation;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.qualification = qualification;
		this.country = country;
		this.landmark = landmark;
		this.companyId = companyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getPfno() {
		return pfno;
	}
	public void setPfno(Long pfno) {
		this.pfno = pfno;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDirectReportingManager() {
		return directReportingManager;
	}
	public void setDirectReportingManager(String directReportingManager) {
		this.directReportingManager = directReportingManager;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "PersonDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", cpassword=" + cpassword + ", gender=" + gender + ", dob=" + dob
				+ ", phoneNumber=" + phoneNumber + ", employeeId=" + employeeId + ", state=" + state + ", city=" + city
				+ ", zipCode=" + zipCode + ", designation=" + designation + ", pfno=" + pfno + ", department="
				+ department + ", directReportingManager=" + directReportingManager + ", workLocation=" + workLocation
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", qualification="
				+ qualification + ", country=" + country + ", landmark=" + landmark + ", companyId=" + companyId + "]";
	}
	
}
