package by.htp.travelserviceWEB.entity;

import java.io.Serializable;

import by.htp.travelserviceWEB.entity.dto.CustomerTO;

public class Customer extends CustomerTO implements Entity, Serializable {

	private static final long serialVersionUID = 1114361367677869178L;
	
	private Integer customerId;
	
	public Customer() {}

	public Customer(Integer customerId, String login, String password, 
					String name, String surname, String gender,
					String birthday, String passport, String email, 
					String phoneNumber, String driverLicense, Integer roleId) {
		
		super(login, password, name, surname, gender, birthday, 
			  passport, email, phoneNumber, driverLicense, roleId);
		
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", getName()=" + getName() + ", getSurname()=" + getSurname() + ", getGender()=" + getGender()
				+ ", getBirthday()=" + getBirthday() + ", getPassport()=" + getPassport() + ", getEmail()=" + getEmail()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getDriverLicense()=" + getDriverLicense()
				+ ", getRoleId()=" + getRoleId() + ", toString()=" + super.toString() + "]";
	}
	
	
}
