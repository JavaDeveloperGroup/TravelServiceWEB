package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;

public interface CustomerDao {
	
	Customer fetchCustomer(CustomerTOLP userDTO);
	AdminTOWP fetchAdmin(CustomerTOLP userDTO);
	Customer makeCustomer(CustomerTO customerTO);
	
}