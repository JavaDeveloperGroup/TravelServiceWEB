package by.htp.travelserviceWEB.service.impl;

import java.sql.SQLException;

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
		Customer customer = customerDao.makeCustomer(customerTO);
		customer.setLogin(customerTO.getLogin());
		customer.setPassword(customerTO.getPassword());
		customer.setName(customerTO.getName());
		customer.setSurname(customerTO.getSurname());
		customer.setBirthday(customerTO.getBirthday());
		customer.setGender(customerTO.getGender());
		customer.setPassport(customerTO.getPassport());
		customer.setEmail(customerTO.getEmail());
		customer.setPhoneNumber(customerTO.getPhoneNumber());
		customer.setDriverLicence(customerTO.getDriverLicence());
		customer.setRoleId(customerTO.getRoleId());
		return customer;
	}

	@Override
	public Customer updateAccountCustomer(Customer customer) throws MySQLIntegrityConstraintViolationException {
		return customerDao.updateAccountCustomer(customer);
	}
}