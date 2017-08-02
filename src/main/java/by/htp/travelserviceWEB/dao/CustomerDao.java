package by.htp.travelserviceWEB.dao;

import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;

public interface CustomerDao {
	
	Customer fetchCustomer(CustomerTOLP userDTO);
	AdminTOWP fetchAdmin(CustomerTOLP userDTO);
	Customer makeCustomer(CustomerTO customerTO) throws MySQLIntegrityConstraintViolationException;
	Customer updateAccountCustomer(Customer customer) throws MySQLIntegrityConstraintViolationException;
}