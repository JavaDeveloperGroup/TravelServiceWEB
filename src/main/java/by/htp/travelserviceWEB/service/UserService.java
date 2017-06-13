package by.htp.travelserviceWEB.service;

import java.sql.Date;

import by.htp.travelserviceWEB.dto.CustomerDTO;
import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;

public interface UserService {

	Customer authoriseCustomer(UserDTO userDTO);
	Admin authoriseAdmin(UserDTO userDTO);
	Customer registrationCustomer(CustomerDTO customerDTO);
}