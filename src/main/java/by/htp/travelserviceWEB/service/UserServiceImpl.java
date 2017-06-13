package by.htp.travelserviceWEB.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.dao.UserDaoImpl;
import by.htp.travelserviceWEB.dto.CustomerDTO;
import by.htp.travelserviceWEB.dto.UserDTO;
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

	public Customer authoriseCustomer(UserDTO userDTO) {
		return userDao.fetchCustomer(userDTO);
	}

	@Override
	public Admin authoriseAdmin(UserDTO userDTO) {
		return userDao.fetchAdmin(userDTO);
	}

	@Override
	public Customer registrationCustomer(CustomerDTO customerDTO) {
		return userDao.makeCustomer(customerDTO);
	}

<<<<<<< HEAD
=======
	@Override
	public Customer registrationCustomer(String login, String password, String name, String surname, String gender,
			Date birthday, String passport, String email, String phoneNumber, String driverLicence, Role role) {
		Customer customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, null);
		return userDao.makeCustomer(customer);
	}

>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
}