package by.htp.travelserviceWEB.service.impl;

import by.htp.travelserviceWEB.dao.factory.DaoFactory;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.UserService;

public class UserServiceImpl implements UserService {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	
	private UserServiceImpl() {
	}

	private static class Singletone {
		private static final UserServiceImpl INSTANCE = new UserServiceImpl();
	}

	public static UserServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer authoriseCustomer(UserTO userDTO) {
		return daoFactory.getUserService().fetchCustomer(userDTO);
	}

	@Override
	public Admin authoriseAdmin(UserTO userDTO) {
		return daoFactory.getUserService().fetchAdmin(userDTO);
	}

	@Override
	public Customer registrationCustomer(Customer customer) {
		return daoFactory.getUserService().makeCustomer(customer);
	}

}