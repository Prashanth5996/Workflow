package com.persondata.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.persondata.dto.EquipmentDTO;
import com.persondata.dto.PersonDTO;
import com.persondata.dto.PersonRowMapper;
import com.persondata.dto.SignUp;
import com.persondata.dto.UserLogin;
import com.persondata.model.Equipment;
import com.persondata.model.Organization;
import com.persondata.model.Person;

@Service
public class PersonServiceImp implements PersonService{
	
	@Autowired
    public JdbcTemplate jt;
	
	//SignUp AND Login
	private final String SQL_SIGNUP = "INSERT INTO person(email,password) VALUES (?,?)";
	private final String SQL_FIND_LOGIN = "SELECT COUNT(*) FROM person WHERE email = ? AND password = ? AND userId = ?";
	//Save Person , Add-New-Employee , ADD_PROFESSTIONAL_INFO
	private final String SQL_SAVE_PERSONS = "UPDATE person SET firstName=?, lastName=?,gender=?, dob=?,phoneNumber=? WHERE userId=?";
	private final String SQL_ADD_NEW_EMPLOYEE = "UPDATE person SET firstName=?, lastName=?, email=?, gender=?, phoneNumber=?, qualification=?,"
			+ " dob=?, addressLine1=?, addressLine2=?, landmark=?, country=?, city=?, state=?, zipCode=?, companyId=? WHERE userId=?";
	private final String SQL_ADD_PROFESSTIONAL_INFO = "UPDATE person SET designation=?, pfno=?, department=?, directReportingManager=?,"
			+ " workLocation=? WHERE userId=?";
	//Save EQUIPMENT
	private final String SQL_INSERT_EQUIPMENT = "INSERT INTO equipment(deviceprovidedby,devicetype,modelname,serialnumber,"
	    		+ "supplydate,employeeId) VALUES (?,?,?,?,?,?)";
	//Save ORGANIZATION
    private final String SQL_INSERT_ORGANIZATION = "INSERT INTO organization(cname,cemail,cphoneNumber,caddressLine1,"
    		+ "caddressLine2,cCountry,cstate,cCity,czipCode) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_DELETE_PERSON = "DELETE FROM person WHERE userId=?";
	private final String SQL_FIND_PERSON = "SELECT * FROM person WHERE userId=?";
    private final String SQL_GET_ALL = "SELECT * FROM person";
    private final String SQL_CHECK_USER = "SELECT COUNT(*) FROM person WHERE userId=?";
    
    //Update Person AND Equipment
    private final String SQL_UPDATE_PERSONS = "UPDATE person SET firstName=?, lastName=?, email=?, password=?, gender=?, dob=?, phoneNumber=?,"
            + "employeeId=?, qualification=?, addressLine1=?, addressLine2=?, landmark=?, country=?, city=?, state=?, zipCode=?, designation=?,"
            + "pfno=?, department=?, directReportingManager=?, workLocation=?,companyId=? WHERE userId=?";
    private final String SQL_UPDATE_EQUIPMENTS = "UPDATE equipment SET deviceprovidedby=?, devicetype=?, modelname=?, serialnumber=?,"
            + "supplydate=? WHERE equipmentId=?";
    
    private final String SQL_SEARCH_BY_ID = "SELECT userId,firstName,lastName FROM person WHERE userId = ?";

    private final String SQL_UPDATE_IMAGE_FILE = "UPDATE person SET image=?,file=?,imageName=?,fileName=? WHERE userId=?";
    
    //Select  Person AND Equipment
    private final String SQL_PERSON_AND_EQUIPMENT ="SELECT u.*, e.* FROM person u INNER JOIN equipment e ON u.userId = e.employeeId";

    //select Organization Person Equipment
    private final String SQL_Organization_PERSON_EQUIPMENT ="select c.*,u.*,e.* from organization c inner join person u on c.companyid=u.companyid inner join equipment e on u.employeeid =e.equipmentid";
	
    @Override
	public String signup(SignUp signUp) {
		try {
                jt.update(SQL_SIGNUP,
                		signUp.getEmail(),signUp.getPassword());
                return "SignUp Successfully...!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid input for SignUp...!!"+e.getMessage();
        }
	}
	
	@Override
    public String Login(UserLogin userLogin, int userId) {
        try {
            int count = jt.queryForObject(SQL_FIND_LOGIN, Integer.class, userLogin.getEmail(), userLogin.getPassword(), userId);
            if (count > 0) {
                return "UserLogin Successfully...!";
            } else {
                return "Invalid credentials...! OR No Record Found..??";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to Login...!" + e.getMessage();
        }
    }
		 
	@Override
	public String savePersons(Person persons, int userId) {
		try {
			 int userCount = jt.queryForObject(SQL_CHECK_USER, Integer.class, userId);
			 if(userCount>0) {
				 jt.update(SQL_SAVE_PERSONS, persons.getFirstName(), persons.getLastName(),persons.getGender(),
						 persons.getDob(),persons.getPhoneNumber(), userId);
            return "New Persons Data Saved Successfully...!";
			} else {
	                return "User with ID " + userId + " does not exist in the database.";
	        }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to Save Persons Data...!" + e.getMessage();
        }
	}

	@Override
	public String addnewEmployee(Person persons, int userId) {
		try {
			 int userCount = jt.queryForObject(SQL_CHECK_USER, Integer.class, userId);
			 if(userCount>0) {
				 jt.update(SQL_ADD_NEW_EMPLOYEE, persons.getFirstName(), persons.getLastName(),persons.getEmail(),persons.getGender(),
						 persons.getPhoneNumber(),persons.getQualification(),persons.getDob(),persons.getAddressLine1(),persons.getAddressLine2(),
                    persons.getLandmark(),persons.getCountry(),persons.getCity(),persons.getState(),persons.getZipCode(),persons.getCompanyId(), userId);
           return "New Employee Data Saved Successfully...!";
			} else {
	                return "User with ID " + userId + " does not exist in the database.";
	        }
       } catch (Exception e) {
           e.printStackTrace();
           return "Failed to Save New Employee Data...!" + e.getMessage();
       }
	}

	@Override
	public String addProfessionalInfo(Person persons, int userId) {
		try {
			 int userCount = jt.queryForObject(SQL_CHECK_USER, Integer.class, userId);
			 if(userCount>0) {
				 jt.update(SQL_ADD_PROFESSTIONAL_INFO, persons.getDesignation(), persons.getPfno(),persons.getDepartment(), 
						 persons.getDirectReportingManager(), persons.getWorkLocation(), userId);
          return "Professional Info Data Saved Successfully...!";
			} else {
	                return "User with ID " + userId + " does not exist in the database.";
	        }
      } catch (Exception e) {
          e.printStackTrace();
          return "Failed to Save Professional Info Data...!" + e.getMessage();
      }

	}
	
	@Override
	public String saveEquipment(Equipment equipments) {
		try {
	        	 jt.update(SQL_INSERT_EQUIPMENT,equipments.getDeviceprovidedby(),equipments.getDevicetype(),equipments.getModelname(),
    				equipments.getSerialnumber(),equipments.getSupplydate(),equipments.getEmployeeId());
	        	 return "EquipmentDetails Data Saved Successfully...!";
		} catch (Exception e) {
			 e.printStackTrace();
	    	   return "Failed to Save EquipmentDetails Data...!"+e.getMessage();
		}
	}

	@Override
	public String saveOrganization(Organization organizations) {
		try {
    		jt.update(SQL_INSERT_ORGANIZATION,organizations.getCname(),organizations.getCemail(),
    				organizations.getCphoneNumber(),organizations.getCaddressLine1(),organizations.getCaddressLine2(),organizations.getcCountry(),
    				organizations.getCstate(),organizations.getcCity(),organizations.getCzipCode());
    		return "OrganizationDetails Data Saved Successfully...!";
		} catch (Exception e) {
			 e.printStackTrace();
	    	   return "Failed to Save OrganizationDetails Data...!"+e.getMessage();
		}
	}
	
	@Override
	public String deletePerson(int userId) {
    	try {
			int result = jt.update(SQL_DELETE_PERSON, userId);
			if(result >0) {
				return "Person Data Deleted Successfully...!";
			}else {
				return "Failed to Delete Person Id Not Found...!";
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return "Failed to Delete Person Id Not Found...!";
		}
	}


	@Override
    public String updatePersonANDEquipment(PersonDTO personDTO, int userId, EquipmentDTO equipmentDTO) {
        try {
        	Person existingPerson = jt.queryForObject("SELECT * FROM person WHERE userId=?", new BeanPropertyRowMapper<>(Person.class), userId);
            Equipment existingEquipment = jt.queryForObject("SELECT * FROM equipment WHERE employeeId=?", new BeanPropertyRowMapper<>(Equipment.class), existingPerson.getEmployeeId());
            if (personDTO.getFirstName() != null) existingPerson.setFirstName(personDTO.getFirstName());
            if (personDTO.getLastName() != null) existingPerson.setLastName(personDTO.getLastName());
            if (personDTO.getEmail() != null) existingPerson.setEmail(personDTO.getEmail());
            if (personDTO.getPassword() != null) existingPerson.setPassword(personDTO.getPassword());
            if (personDTO.getGender() != null) existingPerson.setGender(personDTO.getGender());
            if (personDTO.getDob() != null) existingPerson.setDob(personDTO.getDob());
            if (personDTO.getPhoneNumber() != null) existingPerson.setPhoneNumber(personDTO.getPhoneNumber());
            if (personDTO.getEmployeeId() != null) existingPerson.setEmployeeId(personDTO.getEmployeeId());
            if (personDTO.getQualification() != null) existingPerson.setQualification(personDTO.getQualification());
            if (personDTO.getAddressLine1() != null) existingPerson.setAddressLine1(personDTO.getAddressLine1());
            if (personDTO.getAddressLine2() != null) existingPerson.setAddressLine2(personDTO.getAddressLine2());
            if (personDTO.getLandmark() != null) existingPerson.setLandmark(personDTO.getLandmark());
            if (personDTO.getCountry() != null) existingPerson.setCountry(personDTO.getCountry());
            if (personDTO.getCity() != null) existingPerson.setCity(personDTO.getCity());
            if (personDTO.getLastName() != null) existingPerson.setState(personDTO.getState());
            if (personDTO.getZipCode() != null) existingPerson.setZipCode(personDTO.getZipCode());
            if (personDTO.getDesignation() != null) existingPerson.setDesignation(personDTO.getDesignation());
            if (personDTO.getPfno() != null) existingPerson.setPfno(personDTO.getPfno());
            if (personDTO.getDepartment() != null) existingPerson.setDepartment(personDTO.getDepartment());
            if (personDTO.getDirectReportingManager() != null) existingPerson.setDirectReportingManager(personDTO.getDirectReportingManager());
            if (personDTO.getWorkLocation() != null) existingPerson.setWorkLocation(personDTO.getWorkLocation());
            if (personDTO.getCompanyId() != null) existingPerson.setCompanyId(personDTO.getCompanyId());
            
            if (equipmentDTO.getDeviceprovidedby() != null) existingEquipment.setDeviceprovidedby(equipmentDTO.getDeviceprovidedby());
            if (equipmentDTO.getDevicetype() != null) existingEquipment.setDevicetype(equipmentDTO.getDevicetype());
            if (equipmentDTO.getModelname() != null) existingEquipment.setModelname(equipmentDTO.getModelname());
            if (equipmentDTO.getSerialnumber() != null) existingEquipment.setSerialnumber(equipmentDTO.getSerialnumber());
            if (equipmentDTO.getSupplydate() != null) existingEquipment.setSupplydate(equipmentDTO.getSupplydate());
            
            jt.update(SQL_UPDATE_PERSONS, existingPerson.getFirstName(), existingPerson.getLastName(), existingPerson.getEmail(),
                    existingPerson.getPassword(), existingPerson.getGender(), existingPerson.getDob(), existingPerson.getPhoneNumber(),
                    existingPerson.getEmployeeId(), existingPerson.getQualification(), existingPerson.getAddressLine1(),
                    existingPerson.getAddressLine2(), existingPerson.getLandmark(), existingPerson.getCountry(), existingPerson.getCity(),
                    existingPerson.getState(), existingPerson.getZipCode(), existingPerson.getDesignation(), existingPerson.getPfno(),
                    existingPerson.getDepartment(), existingPerson.getDirectReportingManager(), existingPerson.getWorkLocation(),
                    existingPerson.getCompanyId(), userId);  
            jt.update(SQL_UPDATE_EQUIPMENTS, existingEquipment.getDeviceprovidedby(), existingEquipment.getDevicetype(),
                    existingEquipment.getModelname(), existingEquipment.getSerialnumber(), existingEquipment.getSupplydate(),
            		userId);

            return "PersonANDEquipment Data Updated Successfully...!";
        } catch (EmptyResultDataAccessException e) {
            return "User with ID " + userId + " does not exist in the database.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to Update PersonANDEquipment Data...!" + e.getMessage();
        }
    }


	@Override
	public String getOnePerson(int userId) {
		try {
			 Person	person =jt.queryForObject(SQL_FIND_PERSON, new BeanPropertyRowMapper<>(Person.class), userId);
			return person+"";
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid userId No Record Found...!!";
		}
	}

	@Override
	public List<Person> getAllPersons() {
		try {
			List<Person> personsList = jt.query(SQL_GET_ALL, new BeanPropertyRowMapper<>(Person.class));
	        return personsList;
		} catch (Exception e) {
			e.printStackTrace();
            return new ArrayList<>();
		}
	}

	@Override
	public List<Map<String, Object>> getPersonAndEquipment() {
	    try {
	        List<Map<String, Object>> resultList = jt.queryForList(SQL_PERSON_AND_EQUIPMENT);
	        return resultList.stream()
	                .map(result -> {
	                    Map<String, Object> finalResult = new LinkedHashMap<>();
	                    Map<String, Object> person = new LinkedHashMap<>();
	                    person.put("userId", result.get("userId"));
	                    person.put("firstName", result.get("firstName"));
	                    person.put("lastName", result.get("lastName"));
	    	            person.put("email", result.get("email"));
	    	            person.put("password", result.get("password"));
	    	            person.put("gender", result.get("gender"));
	    	            person.put("dob", result.get("dob"));
	    	            person.put("phoneNumber", result.get("phoneNumber"));
	    	            person.put("employeeId", result.get("employeeId"));
	    	            person.put("state", result.get("state"));
	    	            person.put("city", result.get("city"));
	    	            person.put("zipCode", result.get("zipCode"));
	    	            person.put("designation", result.get("designation"));
	    	            person.put("pfno", result.get("pfno"));
	    	            person.put("department", result.get("department"));
	    	            person.put("directReportingManager", result.get("directReportingManager"));
	    	            person.put("workLocation", result.get("workLocation"));
	    	            person.put("addressLine1", result.get("addressLine1"));
	    	            person.put("addressLine2", result.get("addressLine2"));
	    	            person.put("qualification", result.get("qualification"));
	    	            person.put("country", result.get("country"));
	    	            person.put("landmark", result.get("landmark"));
	                    person.put("companyId", result.get("companyId"));
	                    finalResult.put("person", person);

	                    Map<String, Object> equipment = new LinkedHashMap<>();
	                    equipment.put("equipmentId", result.get("equipmentId"));
	                    equipment.put("deviceprovidedby", result.get("deviceprovidedby"));
	    	            equipment.put("devicetype", result.get("devicetype"));
	    	            equipment.put("modelname", result.get("modelname"));
	    	            equipment.put("serialnumber", result.get("serialnumber"));
	    	            equipment.put("supplydate", result.get("supplydate"));
	                    equipment.put("employeeId", result.get("employeeId"));
	                    finalResult.put("equipment", equipment);
	                    return finalResult;
	                })
	                .collect(Collectors.toList());
	    } catch (Exception e) {
	        e.printStackTrace();
	        e.getMessage();
	        return Collections.emptyList();
	    }
	}

	@Override
	public String searchById(int userId) {
		try {
			Person person = jt.queryForObject(SQL_SEARCH_BY_ID, new BeanPropertyRowMapper<>(Person.class), userId);
			return String.format("{\"userId\": %d, \"firstName\": \"%s\", \"lastName\": \"%s\"}",
        		person.getUserId(), person.getFirstName(), person.getLastName());
			} catch (EmptyResultDataAccessException e) {
				return "Invalid userId, No Record Found...!!";
			}
	}
	
	@Override
    public String addImageAndFile(byte[] image, byte[] file,String imageName,String fileName,int userId) {
		try {
		 int userCount = jt.queryForObject(SQL_CHECK_USER, Integer.class,userId);
		 if(userCount>0) {
            jt.update(SQL_UPDATE_IMAGE_FILE, image, file,imageName,fileName,userId);
            return "Image and File Data Uploaded Successfully....!";
		 } else {
             return "User with ID " + userId + " does not exist in the database.";
         }
     } catch (Exception e) {
         e.printStackTrace();
         return "Failed to Upload Image and File Data: " + e.getMessage();
     }   
    }

	@Override
	public List<Map<String, Object>> getOrganizationPersonEquipment() {
		try {
	        List<Map<String, Object>> resultList = jt.queryForList(SQL_Organization_PERSON_EQUIPMENT);
	        return resultList.stream()
	                .map(result -> {
	                    Map<String, Object> finalResult = new LinkedHashMap<>();
	                    Map<String, Object> organization = new LinkedHashMap<>();
	                    organization.put("companyId",result.get("companyId"));
	                    organization.put("cname",result.get("cname"));
	                    organization.put("cemail",result.get("cemail"));
	                    organization.put("cphoneNumber",result.get("cphoneNumber"));
	                    organization.put("caddressLine1",result.get("caddressLine1"));
	                    organization.put("caddressLine2",result.get("caddressLine2"));
	                    organization.put("cCountry",result.get("cCountry"));
	                    organization.put("cstate",result.get("cstate"));
	                    organization.put("cCity",result.get("cCity"));
	                    organization.put("czipCode",result.get("czipCode"));
	                    finalResult.put("organization",organization);
	                    
	                    Map<String, Object> person = new LinkedHashMap<>();
	                    person.put("userId", result.get("userId"));
	                    person.put("firstName", result.get("firstName"));
	                    person.put("lastName", result.get("lastName"));
	    	            person.put("email", result.get("email"));
	    	            person.put("password", result.get("password"));
	    	            person.put("gender", result.get("gender"));
	    	            person.put("dob", result.get("dob"));
	    	            person.put("phoneNumber", result.get("phoneNumber"));
	    	            person.put("employeeId", result.get("employeeId"));
	    	            person.put("state", result.get("state"));
	    	            person.put("city", result.get("city"));
	    	            person.put("zipCode", result.get("zipCode"));
	    	            person.put("designation", result.get("designation"));
	    	            person.put("pfno", result.get("pfno"));
	    	            person.put("department", result.get("department"));
	    	            person.put("directReportingManager", result.get("directReportingManager"));
	    	            person.put("workLocation", result.get("workLocation"));
	    	            person.put("addressLine1", result.get("addressLine1"));
	    	            person.put("addressLine2", result.get("addressLine2"));
	    	            person.put("qualification", result.get("qualification"));
	    	            person.put("country", result.get("country"));
	    	            person.put("landmark", result.get("landmark"));
	                    person.put("companyId", result.get("companyId"));
	                    finalResult.put("person", person);

	                    Map<String, Object> equipment = new LinkedHashMap<>();
	                    equipment.put("equipmentId", result.get("equipmentId"));
	                    equipment.put("deviceprovidedby", result.get("deviceprovidedby"));
	    	            equipment.put("devicetype", result.get("devicetype"));
	    	            equipment.put("modelname", result.get("modelname"));
	    	            equipment.put("serialnumber", result.get("serialnumber"));
	    	            equipment.put("supplydate", result.get("supplydate"));
	                    equipment.put("employeeId", result.get("employeeId"));
	                    finalResult.put("equipment", equipment);
	                    return finalResult;
	                })
	                .collect(Collectors.toList());
	    } catch (Exception e) {
	        e.printStackTrace();
	        e.getMessage();
	        return Collections.emptyList();
	    }
	}

	
}
