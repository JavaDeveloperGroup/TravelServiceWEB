package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserDao {
	Customer fetchCustomer(String login, String password);
	Admin fetchAdmin(String login, String password);
}