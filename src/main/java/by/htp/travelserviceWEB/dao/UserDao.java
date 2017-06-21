package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserDao {
	Customer fetchCustomer(UserDTO userDTO);
	Admin fetchAdmin(UserDTO userDTO);
	Customer makeCustomer(Customer customer);
}