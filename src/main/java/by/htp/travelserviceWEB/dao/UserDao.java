package by.htp.travelserviceWEB.dao;

import javax.servlet.http.HttpServletRequest;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserDao {
	Customer fetchCustomer(String login, String password);
	Admin fetchAdmin(String login, String password);
	Customer makeCustomer(Customer customer);
}