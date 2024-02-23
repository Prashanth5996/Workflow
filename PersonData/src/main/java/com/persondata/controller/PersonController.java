package com.persondata.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.persondata.dto.EquipmentDTO;
import com.persondata.dto.PersonAndEquipmentDTO;
import com.persondata.dto.PersonDTO;
import com.persondata.dto.SignUp;
import com.persondata.dto.UserLogin;
import com.persondata.model.Equipment;
import com.persondata.model.Organization;
import com.persondata.model.Person;
import com.persondata.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("/signUp")
    public String saveSignUp(@RequestBody SignUp signUp) {
        if (signUp != null && signUp.getPassword().equals(signUp.getCpassword())) {
            return personService.signup(signUp);
        } else {
            return "Password and Confirm Password does not match!";
        } 
    }

	@PostMapping("/login/{userId}")
    public String saveLogin(@RequestBody UserLogin userLogin, @PathVariable Integer userId) {
        if (userLogin != null && userLogin.getEmail() != null && userLogin.getPassword() != null) {
            return personService.Login(userLogin, userId);
        } else {
            return "Invalid input for UserLogin...!!";
        }
    }
	
	@PatchMapping("/save/{userId}")
    public String savePerson(@RequestBody Person person, @PathVariable Integer userId) {
        if (person != null) {
            return personService.savePersons(person, userId);
        } else {
            return "Invalid input for saving Persons...!!";
        }
    }
	
	@PatchMapping("/addEmp/{userId}")
    public String addnewEmployee(@RequestBody Person person, @PathVariable Integer userId) {
        if (person != null) {
            return personService.addnewEmployee(person, userId);
        } else {
            return "Invalid input for saving New Employee...!!";
        }
    }
	
	@PatchMapping("/addProfessional/{userId}")
    public String addProfessionalInfo(@RequestBody Person person, @PathVariable Integer userId) {
        if (person != null) {
            return personService.addProfessionalInfo(person, userId);
        } else {
            return "Invalid input for saving Professional Info...!!";
        }
    }
	
	@PostMapping("/save/equipments")
    public String saveEquipment(@RequestBody Equipment equipments) {
		if(equipments !=null) {
			return personService.saveEquipment(equipments);
		}else {
			return "Invalid input for saving EquipmentDetails...!!";
		}
    }
	
	@PostMapping("/save/organization")
    public String saveOrganization(@RequestBody Organization organizations ) {
		if(organizations !=null) {
			return personService.saveOrganization(organizations);
		}else {
			return "Invalid input for saving OrganizationDetails...!!";
		}
    }
	
	@PatchMapping("/personANDequipment/{userId}")
    public String updatePersonANDEquipment(@RequestBody PersonAndEquipmentDTO updateData,
                                           @PathVariable int userId) {
        if (updateData.getPerson() != null && updateData.getEquipment() != null) {
            return personService.updatePersonANDEquipment(updateData.getPerson(), userId, updateData.getEquipment());
        } else {
            return "Invalid input for saving updatePersonANDEquipment...!!";
        }
    }


	@DeleteMapping("/delete/{userId}")
	public String deletePersons(@PathVariable Integer userId) {
		 if(userId!=null) {
			 return personService.deletePerson(userId);
		 }else {
			return "No Id Found for deletion...!!";
		 }           
    }
	
	 @GetMapping("/get/{userId}")
	 public String getOnePerson(@PathVariable Integer userId) {
	        if (userId!= null) {
	        	 return personService.getOnePerson(userId);
			} else {
				return "Invalid userId No Record Found...!!";
			}
	    }
	
	 @GetMapping("/getAll")
	 public String getAllPersons() {
	        List<Person> persons = personService.getAllPersons();
	        if (!persons.isEmpty()) {
	        	 return ""+persons;
			} else {
				return "No Records Found...!!";
			}
	  }
	 

	 @GetMapping("/personANDequipment")
	 public List<Map<String, Object>> getPersonAndEquipment() {
	        return personService.getPersonAndEquipment();
     }
	 
	 @GetMapping("/search/{userId}")
	 public String SearchById(@PathVariable Integer userId) {
	        if (userId!= null) {
	        	 return personService.searchById(userId);
			} else {
				return "Invalid userId No Record Found...!!";
			}
	 }

	 @PatchMapping("/upload/{userId}")
	 public String insertImageAndFile(@PathVariable Integer userId,@RequestParam("image") MultipartFile image,
	                                     @RequestParam("file") MultipartFile file) {
	        try {
	            byte[] imageBytes = image.getBytes();
	            String imageName = image.getOriginalFilename();
	            byte[] fileBytes = file.getBytes();
	            String fileName = file.getOriginalFilename();
	            return personService.addImageAndFile(imageBytes, fileBytes, imageName, fileName, userId);
	        } catch (IOException e) {
	            return "Error processing image or file: " + e.getMessage();
	        }
	  }
	 
	 @GetMapping("/organization/person/equipment")
	 public List<Map<String, Object>> getOrganizationPersonEquipment() {
	        return personService.getOrganizationPersonEquipment();
     }
}

