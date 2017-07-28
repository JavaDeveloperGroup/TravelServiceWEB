package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.entity.dto.AdminTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;

public interface CustomerDao {
	
	CustomerTO fetchCustomer(CustomerTO customerTO, CustomerTOLP userDTO);
	AdminTO fetchAdmin(AdminTO admin, CustomerTOLP userDTO);
	CustomerTO makeCustomer(CustomerTO customerTO);
	
}