package by.htp.travelserviceWEB.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.ConnectionPool;
import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.entity.dto.UserTO;

public class UserDaoImpl implements UserDao {

	private ConnectionPool connector = ConnectionPool.getInstance();
	private Connection connection;

	private UserDaoImpl() {
	}

	private static class Singletone {
		private static final UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer fetchCustomer(UserTO userDTO) {

		Customer customer = null;

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM customer where customer.login = ? and customer.password = ?");
			ps.setString(1, userDTO.getLogin());
			ps.setString(2, userDTO.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer customerId = rs.getInt(1);
				String login = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String surname = rs.getString(5);
				String gender = rs.getString(6);
				String birthday = rs.getString(7);
				String passport = rs.getString(8);
				String email = rs.getString(9);
				String phoneNumver = rs.getString(10);
				String driverLicence = rs.getString(11);
				Integer idRole = rs.getInt(12);
				
				customer = new Customer(customerId, login, password, name, surname, gender, birthday, passport, email,
						phoneNumver, driverLicence, idRole);
			}
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public Admin fetchAdmin(UserTO userDTO) {

		Admin admin = null;

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin where admin.login = ? and admin.password = ?");
			ps.setString(1, userDTO.getLogin());
			ps.setString(2, userDTO.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer adminId = rs.getInt(1);
				String login = rs.getString(2);
				Integer idRole = rs.getInt(4);

				admin = new Admin(adminId, login, idRole);
			}
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public Customer makeCustomer(Customer customer) throws SQLException {
		
	
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO travelservice.customer "
				+ "(login, password, name, surname, gender, "
				+ "birthday, passport, email, phone_number, driver_licence) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", 
				PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, customer.getLogin());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getName());
			ps.setString(4, customer.getSurname());
			ps.setString(5, customer.getGender());
			ps.setString(6, customer.getBirthday());
			ps.setString(7, customer.getPassport());
			ps.setString(8, customer.getEmail());
			ps.setString(9, customer.getPhoneNumber());
			ps.setString(10, customer.getDriverLicence());
			
			ps.executeUpdate(); 	
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				customer.setCustomerId(Integer.valueOf(generatedKeys.getInt(1)));		
			}
			
			connector.putBack(connection);
		
		return customer;
	}

	@Override
	public Customer updateAccountCustomer(Customer customer) throws SQLException {
		
		connection = connector.getConnection();
		PreparedStatement ps = connection.prepareStatement("UPDATE `travelservice`.`customer` SET `password`=?, `name`=?, `surname`=?, `gender`=?, `birthday`=?, `passport`=?, `email`=?, `phone_driver`=?, `driver_licence`=? WHERE  `id_customer`=?;");
		
		ps.setString(10, String.valueOf(customer.getCustomerId()));
		ps.setString(1, customer.getPassword());
		ps.setString(2, customer.getName());
		ps.setString(3, customer.getSurname());
		ps.setString(4, customer.getGender());
		ps.setString(5, customer.getBirthday());
		ps.setString(6, customer.getPassport());
		ps.setString(7, customer.getEmail());
		ps.setString(8, customer.getPhoneNumber());
		ps.setString(9, customer.getDriverLicence());
		
		ps.executeUpdate(); 	
		
		connector.putBack(connection);
		return customer;
	}
}
