package by.htp.travelserviceWEB.service;

import java.sql.Date;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;

public interface UserService {

	Customer authoriseCustomer(String login, String password);
	Admin authoriseAdmin(String login, String password);
	Customer registrationCustomer(String login, String password, String name, String surname, String gender, Date birthday, String passport, String email, String phoneNumber, String driverLicence, Role role);
}