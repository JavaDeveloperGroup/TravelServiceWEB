package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.CustomerImpl;

public interface UserService {

	CustomerImpl authoriseCustomer(UserDTO userDTO);
	Admin authoriseAdmin(UserDTO userDTO);
	CustomerImpl registrationCustomer(Customer customerDTO);
}