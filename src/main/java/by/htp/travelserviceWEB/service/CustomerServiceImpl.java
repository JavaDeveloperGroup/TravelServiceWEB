package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.dao.CustomerDaoImpl;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = CustomerDaoImpl.getInstance();
	
	private CustomerServiceImpl() {
	}

	private static class Singletone {
		private static final CustomerServiceImpl INSTANCE = new CustomerServiceImpl();
	}

	public static CustomerServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer authoriseCustomer(String login, String password) {
		return customerDao.fetchCustomer(login, password);
	}

	@Override
	public Admin authoriseAdmin(String login, String password) {
		
		return null;
	}

}