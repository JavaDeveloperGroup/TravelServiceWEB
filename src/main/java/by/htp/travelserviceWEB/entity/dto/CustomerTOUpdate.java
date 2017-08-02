package by.htp.travelserviceWEB.entity.dto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class CustomerTOUpdate implements Entity, Serializable {
	
	private static final long serialVersionUID = -5155826831396257723L;
	
	private String password;
	private String gender;
	private String birthday;
	private String email;
	private String phoneNumber;
	private String driverLicence;
	
	public CustomerTOUpdate() {}

	public CustomerTOUpdate(String password, String gender, String birthday, String email, String phoneNumber,
			String driverLicence) {
		super();
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.driverLicence = driverLicence;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
}