package by.htp.travelserviceWEB.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.dao.UserDaoImpl;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;

public class UserServiceImpl implements UserService {

	private UserDao userDao = UserDaoImpl.getInstance();
	
	private UserServiceImpl() {
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	public Customer authoriseCustomer(String login, String password) {
		return userDao.fetchCustomer(login, password);
	}

	@Override
	public Admin authoriseAdmin(String login, String password) {
		return userDao.fetchAdmin(login, password);
	}

	@Override
	public Customer registrationCustomer(String login, String password, String name, String surname, String gender,
			Date birthday, String passport, String email, String phoneNumber, String driverLicence, Role role) {
		Customer customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, null);
		return userDao.makeCustomer(customer);
	}

}