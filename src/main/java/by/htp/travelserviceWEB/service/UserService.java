package by.htp.travelserviceWEB.service;

import java.sql.SQLException;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserService {

	Customer authoriseCustomer(UserTO userDTO);
	Admin authoriseAdmin(UserTO userDTO);
	Customer registrationCustomer(Customer customer);
	Customer updateAccountCustomer(Customer customer) throws SQLException;
}