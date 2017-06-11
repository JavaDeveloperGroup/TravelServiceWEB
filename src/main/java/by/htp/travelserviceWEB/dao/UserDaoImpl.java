package by.htp.travelserviceWEB.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.htp.travelserviceWEB.connector.MySQLConnector;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;

public class UserDaoImpl implements UserDao {

	private MySQLConnector mySQLConnector = MySQLConnector.getInstance();

	private UserDaoImpl() {
	}

	private static class Singletone {
		private static final UserDaoImpl INSTANCE = new UserDaoImpl();
	}

	public static UserDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	public Customer fetchCustomer(String log, String passw) {

		Customer customer = null;

		try {

			PreparedStatement ps = mySQLConnector.conn().prepareStatement(
					"SELECT * FROM customer left join role on customer.id_role = role.id_role where customer.login = ? and customer.password = ?");
			ps.setString(1, log);
			ps.setString(2, passw);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer userId = null;
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

				userId = rs.getInt(1);
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
				customer = new Customer(userId, login, password, name, surname, gender, birthday, passport, email,
						phoneNumber, driverLicense, role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	public Admin fetchAdmin(String log, String passw) {

		Admin admin = null;

		try {

			PreparedStatement ps = mySQLConnector.conn().prepareStatement("SELECT * FROM admin left join role on admin.id_role = role.id_role where admin.login = ? and admin.password = ?");
			ps.setString(1, log);
			ps.setString(2, passw);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer userId = null;
				String login = null;
				String password = null;

				Role role = null;
				Integer idRole = null;
				String roleName = null;

				userId = rs.getInt(1);
				login = rs.getString(2);
				password = rs.getString(3);
			
				idRole = rs.getInt(5);
				roleName = rs.getString(6);

				role = new Role(idRole, roleName);
				admin = new Admin(userId, login, password, role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}
}
