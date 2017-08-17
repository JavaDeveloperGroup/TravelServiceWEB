package by.htp.travelserviceWEB.service.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.dao.impl.CustomerDaoImpl;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	{
		customerDao = CustomerDaoImpl.getInstance();
	}
	private CustomerServiceImpl() {}

	private static class Singletone {
		private static final CustomerServiceImpl INSTANCE = new CustomerServiceImpl();
	}

	public static CustomerServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer authoriseCustomer(CustomerTOLP customerTOLP) {
		return customerDao.fetchCustomer(customerTOLP);
	}

	@Override
	public AdminTOWP authoriseAdmin(CustomerTOLP customerTOLP) {
		return customerDao.fetchAdmin(customerTOLP);
	}

	@Override
	public Customer registrationCustomer(CustomerTO customerTO) throws MySQLIntegrityConstraintViolationException {
		return customerDao.makeCustomer(customerTO);
	}

	@Override
	public Customer updateAccountCustomer(Customer customerUpdate) throws MySQLIntegrityConstraintViolationException {
		return customerDao.updateAccountCustomer(customerUpdate);
	}
}