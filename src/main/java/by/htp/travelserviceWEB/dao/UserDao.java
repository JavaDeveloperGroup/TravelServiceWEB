package by.htp.travelserviceWEB.dao;

import java.sql.SQLException;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;

public interface UserDao {
	Customer fetchCustomer(UserTO userDTO);
	Admin fetchAdmin(UserTO userDTO);
	Customer makeCustomer(Customer customer) throws SQLException;
	Customer updateAccountCustomer(Customer customer) throws SQLException;
}