package com.persondata.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.persondata.dto.EquipmentDTO;
import com.persondata.dto.PersonDTO;
import com.persondata.dto.SignUp;
import com.persondata.dto.UserLogin;
import com.persondata.model.Equipment;
import com.persondata.model.Organization;
import com.persondata.model.Person;

public interface PersonService {
	
	public String signup(SignUp signUp);
	
	public String Login(UserLogin userLogin,int userId);
	
	public String savePersons(Person persons,int userId);
	
	public String addnewEmployee(Person persons,int userId);
	
	public String addProfessionalInfo(Person persons,int userId);
	
	public String saveEquipment(Equipment equipments);
	
	public String saveOrganization(Organization organizations);
	
	public String updatePersonANDEquipment(PersonDTO personDTO, int userId, EquipmentDTO equipmentDTO);
	
	public String searchById(int userId);
	
	public String deletePerson(int userId);
	
	public String getOnePerson(int userId);
	
	public List<Person> getAllPersons();
	
	public List<Map<String, Object>> getPersonAndEquipment();
	
	public String addImageAndFile(byte[] image, byte[] file,String imageName,String fileName,int userId);
	
	public List<Map<String, Object>> getOrganizationPersonEquipment();
}
