package by.htp.travelserviceWEB.service;

import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.dao.UserDaoImpl;
import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

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
	public Customer registrationCustomer(Customer customer) {
		return userDao.makeCustomer(customer);
	}

}