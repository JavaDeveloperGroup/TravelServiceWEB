package by.htp.travelserviceWEB.entity.dto;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.Entity;

public class CustomerTO implements Entity, Serializable {
	
	private static final long serialVersionUID = -5155826831396257723L;
	
	private String login;
	private String password;
	private String name;
	private String surname;
	private String gender;
	private String birthday;
	private String passport;
	private String email;
	private String phoneNumber;
	private String driverLicence;
	private Integer roleId;
	
	public CustomerTO() {}

	public CustomerTO(String login, String password, String name, 
					  String surname, String gender, String birthday,
					  String passport, String email, String phoneNumber, 
					  String driverLicence, Integer roleId) {
		
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthday = birthday;
		this.passport = passport;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.driverLicence = driverLicence;
		this.roleId = roleId;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
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

	public void setDriverLicence(String driverLicenсe) {
		this.driverLicence = driverLicenсe;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
}