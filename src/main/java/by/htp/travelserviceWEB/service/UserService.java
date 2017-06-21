package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserService {

	Customer authoriseCustomer(UserDTO userDTO);
	Admin authoriseAdmin(UserDTO userDTO);
	Customer registrationCustomer(Customer customer);
}