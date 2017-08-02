package by.htp.travelserviceWEB.service;

import java.sql.SQLException;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;

public interface CustomerService {

	Customer authoriseCustomer(CustomerTOLP customerTOLP);
	AdminTOWP authoriseAdmin(CustomerTOLP customerTOLP);
	Customer registrationCustomer(CustomerTO customerTO) throws SQLException;
	Customer updateAccountCustomer(Customer customer) throws SQLException;
}