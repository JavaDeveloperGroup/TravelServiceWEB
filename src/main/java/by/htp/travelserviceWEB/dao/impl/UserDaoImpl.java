package by.htp.travelserviceWEB.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.Connector;
import by.htp.travelserviceWEB.connector.OwnConnection;
import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.entity.dto.UserTO;

public class UserDaoImpl implements UserDao {

	private OwnConnection connector = OwnConnection.getInstance();
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
				String password = null;
				String name = null;
				String surname = null;
				String gender = null;
				Date birthday = null;
				String passport = null;
				String email = null;
				String phoneNumber = null;
				String driverLicense = null;

				Role role = null;
				Integer idRole = null;
				String roleName = null;

				customerId = rs.getInt(1);
				login = rs.getString(2);
				password = rs.getString(3);
				name = rs.getString(4);
				surname = rs.getString(5);
				gender = rs.getString(6);
				birthday = rs.getDate(7);
				passport = rs.getString(8);
				email = rs.getString(9);
				phoneNumber = rs.getString(10);
				driverLicense = rs.getString(11);
				idRole = rs.getInt(13);
				roleName = rs.getString(14);

				role = new Role(idRole, roleName);
				customer = new Customer(customerId, login, password, name, surname, gender, birthday, passport, email,
						phoneNumber, driverLicense, role);
			}
			connector.getBack(connection);

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
				String password = null;

				Role role = null;
				Integer idRole = null;
				String roleName = null;

				adminId = rs.getInt(1);
				login = rs.getString(2);
				password = rs.getString(3);
			
				idRole = rs.getInt(5);
				roleName = rs.getString(6);

				role = new Role(idRole, roleName);
				admin = new Admin(adminId, login, password, role);
			}
			connector.getBack(connection);

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
			ps.setDate(6, customer.getBirthday());
			ps.setString(7, customer.getPassport());
			ps.setString(8, customer.getEmail());
			ps.setString(9, customer.getPhoneNumber());
			ps.setString(10, customer.getDriverLicense());
			
			ps.executeUpdate(); 	
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				customer.setCustomerId(Integer.valueOf(generatedKeys.getInt(1)));
			}
			connector.getBack(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
