package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserService {

	Customer authoriseCustomer(UserTO userDTO);
	Admin authoriseAdmin(UserTO userDTO);
	Customer registrationCustomer(Customer customer);
}