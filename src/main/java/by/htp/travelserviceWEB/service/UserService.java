package by.htp.travelserviceWEB.service;

import java.sql.Date;

<<<<<<< HEAD
import by.htp.travelserviceWEB.dto.CustomerDTO;
import by.htp.travelserviceWEB.dto.UserDTO;
=======
>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;

public interface UserService {

<<<<<<< HEAD
	Customer authoriseCustomer(UserDTO userDTO);
	Admin authoriseAdmin(UserDTO userDTO);
	Customer registrationCustomer(CustomerDTO customerDTO);
=======
	Customer authoriseCustomer(String login, String password);
	Admin authoriseAdmin(String login, String password);
	Customer registrationCustomer(String login, String password, String name, String surname, String gender, Date birthday, String passport, String email, String phoneNumber, String driverLicence, Role role);
>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
}