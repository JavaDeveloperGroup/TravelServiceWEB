package by.htp.travelserviceWEB.dao;

import javax.servlet.http.HttpServletRequest;

import by.htp.travelserviceWEB.dto.CustomerDTOImpl;
import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.CustomerImpl;

public interface UserDao {
	CustomerImpl fetchCustomer(UserDTO userDTO);
	Admin fetchAdmin(UserDTO userDTO);
	CustomerImpl makeCustomer(Customer customerDTO);
}