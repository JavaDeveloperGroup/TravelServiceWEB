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

}