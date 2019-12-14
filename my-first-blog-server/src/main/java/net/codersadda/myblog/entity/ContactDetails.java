package net.codersadda.myblog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContactDetails {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String skillset;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public ContactDetails(String name, String email, String phoneNumber, String skillset) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.skillset = skillset;
	}

	public ContactDetails() {
		super();
	}
	
}
