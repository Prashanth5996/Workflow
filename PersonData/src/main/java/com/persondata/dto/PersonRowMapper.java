package com.persondata.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.persondata.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Person person = new Person();
	    person.setFirstName(rs.getString("firstName"));
	    person.setLastName(rs.getString("lastName"));
	    person.setEmail(rs.getString("email"));
	    person.setPassword(rs.getString("password"));
	    person.setCpassword(rs.getString("cpassword"));
	    person.setGender(rs.getString("gender"));
	    person.setDob(rs.getDate("dob"));
	    person.setPhoneNumber(rs.getLong("phoneNumber"));
	    person.setEmployeeId(rs.getInt("employeeId"));
	    person.setState(rs.getString("state"));
	    person.setCity(rs.getString("city"));
	    person.setZipCode(rs.getLong("zipCode"));
	    person.setDesignation(rs.getString("designation"));
	    person.setPfno(rs.getLong("pfno"));
	    person.setDepartment(rs.getString("department"));
	    person.setDirectReportingManager(rs.getString("directReportingManager"));
	    person.setWorkLocation(rs.getString("workLocation"));
	    person.setAddressLine1(rs.getString("addressLine1"));
	    person.setAddressLine2(rs.getString("addressLine2"));
	    person.setQualification(rs.getString("qualification"));
	    person.setCountry(rs.getString("country"));
	    person.setLandmark(rs.getString("landmark"));
	    person.setCompanyId(rs.getInt("companyId"));
	    return person;
	}

}
