package by.htp.travelserviceWEB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.MySQLConnector;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private MySQLConnector mySQLConnector = MySQLConnector.getInstance();

	private CustomerDaoImpl() {
	}

	private static class Singletone {
		private static final CustomerDaoImpl INSTANCE = new CustomerDaoImpl();
	}

	public static CustomerDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer fetchCustomer(String login, String password) {
		Customer customer = null;
		PreparedStatement ps = null;

		Connection pool = mySQLConnector.conn();
		try {
			ps = mySQLConnector.prepareStatement("SELECT * FROM customer WHERE  login = ? and password = ?", pool);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String log = rs.getString(2);
				String pass = rs.getString(3);
				customer.setLogin(log);
				customer.setPassword(pass);
			}
			System.out.println(customer.getLogin());
			System.out.println(customer.getPassword());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public Admin fetchAdmin(String login, String password) {

		return null;
	}
}
