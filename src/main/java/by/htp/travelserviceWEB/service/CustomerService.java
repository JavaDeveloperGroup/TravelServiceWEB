package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.entity.dto.AdminTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;

public interface CustomerService {

	CustomerTO authoriseCustomer(CustomerTO customerTO, CustomerTOLP customerTOLP);
	AdminTO authoriseAdmin(AdminTO admin, CustomerTOLP customerTOLP);
	CustomerTO registrationCustomer(CustomerTO customerTO);
	
}