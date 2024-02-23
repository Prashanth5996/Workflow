package com.persondata.dto;

public class PersonAndEquipmentDTO {
	private PersonDTO person;
    private EquipmentDTO equipment;
	public PersonAndEquipmentDTO() {
		super();
	}
	public PersonAndEquipmentDTO(PersonDTO person, EquipmentDTO equipment) {
		super();
		this.person = person;
		this.equipment = equipment;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public EquipmentDTO getEquipment() {
		return equipment;
	}
	public void setEquipment(EquipmentDTO equipment) {
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return "PersonAndEquipmentDTO [person=" + person + ", equipment=" + equipment + "]";
	}

}
