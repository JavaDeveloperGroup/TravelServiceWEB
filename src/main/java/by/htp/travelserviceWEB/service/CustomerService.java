package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public interface CustomerService {

	Customer authoriseCustomer(String login, String password);
	Admin authoriseAdmin(String login, String password);
}