package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOUpdate;
import by.htp.travelserviceWEB.util.EncryptionFdl;

public class Customer implements Entity, Serializable, User {

	private static final long serialVersionUID = 1114361367677869178L;
	
	private Integer customerId;
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
	
	public Customer() {}

	public Customer(Integer customerId, String login, String password, 
					String name, String surname, String gender,
					String birthday, String passport, String email, 
					String phoneNumber, String driverLicence, Integer roleId) {
		
		this.customerId = customerId;
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
	
	public Customer(CustomerTO customerTO) {
		this.login = customerTO.getLogin();
		this.password = customerTO.getPassword();
		this.name = customerTO.getName();
		this.surname = customerTO.getSurname();
		this.gender = customerTO.getGender();
		this.birthday = customerTO.getBirthday();
		this.passport = customerTO.getPassword();
		this.email = customerTO.getEmail();
		this.phoneNumber = customerTO.getPhoneNumber();
		this.driverLicence = customerTO.getDriverLicence();
		this.roleId = customerTO.getRoleId();
	}
	
	public void updateData(CustomerTOUpdate customerTOUpdate) {
		this.password = EncryptionFdl.encrypt(customerTOUpdate.getPassword());
		this.gender = customerTOUpdate.getGender();
		this.birthday = customerTOUpdate.getBirthday();
		this.email = customerTOUpdate.getEmail();
		this.phoneNumber = customerTOUpdate.getPhoneNumber();
		this.driverLicence = customerTOUpdate.getDriverLicence();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", login=" + login + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", gender=" + gender + ", birthday=" + birthday + ", passport=" + passport
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", driverLicence=" + driverLicence + ", roleId="
				+ roleId + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
