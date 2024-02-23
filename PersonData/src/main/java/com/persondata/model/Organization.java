package com.persondata.model;

public class Organization {
	private Integer companyId;
    private String cname;
    private String cemail;
    private Long cphoneNumber;
    private String caddressLine1;
    private String caddressLine2;
    private String cCountry;
    private String cstate;
    private String cCity;
    private Long czipCode;
	public Organization() {
	}
	
	public Organization(Integer companyId, String cname, String cemail, Long cphoneNumber, String caddressLine1,
			String caddressLine2, String cCountry, String cstate, String cCity, Long czipCode) {
		super();
		this.companyId = companyId;
		this.cname = cname;
		this.cemail = cemail;
		this.cphoneNumber = cphoneNumber;
		this.caddressLine1 = caddressLine1;
		this.caddressLine2 = caddressLine2;
		this.cCountry = cCountry;
		this.cstate = cstate;
		this.cCity = cCity;
		this.czipCode = czipCode;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public Long getCphoneNumber() {
		return cphoneNumber;
	}

	public void setCphoneNumber(Long cphoneNumber) {
		this.cphoneNumber = cphoneNumber;
	}

	public String getCaddressLine1() {
		return caddressLine1;
	}

	public void setCaddressLine1(String caddressLine1) {
		this.caddressLine1 = caddressLine1;
	}

	public String getCaddressLine2() {
		return caddressLine2;
	}

	public void setCaddressLine2(String caddressLine2) {
		this.caddressLine2 = caddressLine2;
	}

	public String getcCountry() {
		return cCountry;
	}

	public void setcCountry(String cCountry) {
		this.cCountry = cCountry;
	}

	public String getCstate() {
		return cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public Long getCzipCode() {
		return czipCode;
	}

	public void setCzipCode(Long czipCode) {
		this.czipCode = czipCode;
	}

	@Override
	public String toString() {
		return "Organization [companyId=" + companyId + ", cname=" + cname + ", cemail=" + cemail + ", cphoneNumber="
				+ cphoneNumber + ", caddressLine1=" + caddressLine1 + ", caddressLine2=" + caddressLine2 + ", cCountry="
				+ cCountry + ", cstate=" + cstate + ", cCity=" + cCity + ", czipCode=" + czipCode + "]";
	}
	
}
