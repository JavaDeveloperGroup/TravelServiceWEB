package by.htp.travelserviceWEB.service.impl;

import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.dao.impl.CustomerDaoImpl;
import by.htp.travelserviceWEB.entity.dto.AdminTO;
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
	public CustomerTO authoriseCustomer(CustomerTO customerTO, CustomerTOLP customerTOLP) {
		return customerDao.fetchCustomer(customerTO, customerTOLP);
	}

	@Override
	public AdminTO authoriseAdmin(AdminTO admin, CustomerTOLP customerTOLP) {
		return customerDao.fetchAdmin(admin, customerTOLP);
	}

	@Override
	public CustomerTO registrationCustomer(CustomerTO customerTO) {
		return customerDao.makeCustomer(customerTO);
	}
}