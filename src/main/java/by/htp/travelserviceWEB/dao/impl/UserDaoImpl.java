package by.htp.travelserviceWEB.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.OwnConnectionPool;
import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.entity.dto.UserTO;

public class UserDaoImpl implements UserDao {

	private OwnConnectionPool connector = OwnConnectionPool.getInstance();
	private Connection connection;

	private UserDaoImpl() {
	}

	private static class Singletone {
		private static final UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	public Customer fetchCustomer(UserTO userDTO) {

		Customer customer = null;

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM customer left join role on customer.id_role = role.id_role where customer.login = ? and customer.password = ?");
			ps.setString(1, userDTO.getLogin());
			ps.setString(2, userDTO.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer customerId = null;
				String login = null;
				String name = null;
				String surname = null;
				String driverLicence = null;
				Role role = null;
				Integer idRole = null;
				String roleName = null;

				customerId = rs.getInt(1);
				login = rs.getString(2);
				name = rs.getString(4);
				surname = rs.getString(5);
				driverLicence = rs.getString(11);
				idRole = rs.getInt(13);
				roleName = rs.getString(14);
				role = new Role(idRole, roleName);
				
				customer = new Customer(customerId, login, null, name, surname, null, null, null, null,
						null, driverLicence, role);
			}
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	public Admin fetchAdmin(UserTO userDTO) {

		Admin admin = null;

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM admin left join role on admin.id_role = role.id_role where admin.login = ? and admin.password = ?");
			ps.setString(1, userDTO.getLogin());
			ps.setString(2, userDTO.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer adminId = null;
				String login = null;
				//String password = null;

				Role role = null;
				Integer idRole = null;
				String roleName = null;

				adminId = rs.getInt(1);
				login = rs.getString(2);
				//password = rs.getString(3);
			
				idRole = rs.getInt(5);
				roleName = rs.getString(6);

				role = new Role(idRole, roleName);
				admin = new Admin(adminId, login, role);
			}
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}

	public Customer makeCustomer(Customer customer) {
		
		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO travelservice.customer "
				+ "(login, password, name, surname, gender, "
				+ "birthday, passport, email, phone_number, driver_license) "
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
			customer.setRole(new Role(1, "customer"));
			connector.putBack(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
