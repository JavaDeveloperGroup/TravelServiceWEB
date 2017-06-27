package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;

public interface UserDao {
	Customer fetchCustomer(UserTO userDTO);
	Admin fetchAdmin(UserTO userDTO);
	Customer makeCustomer(Customer customer);
}