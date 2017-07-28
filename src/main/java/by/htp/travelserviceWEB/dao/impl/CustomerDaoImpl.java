package by.htp.travelserviceWEB.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.ConnectionPool;
import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.insert.Insert;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;

public class CustomerDaoImpl implements CustomerDao {

	private final ConnectionPool connector = ConnectionPool.getInstance();
	private Connection connection;
	private final Query query;

	private CustomerDaoImpl() {
		query = new Query();
	}

	private static class Singletone {
		private static final CustomerDaoImpl INSTANCE = new CustomerDaoImpl();
	}

	public static CustomerDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	public CustomerTO fetchCustomer(CustomerTO customerTO, CustomerTOLP userDTO) {
		CustomerTO customer1 = null;

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM customer where customer.login = ? and customer.password = ?");
			ps.setString(1, userDTO.getLogin());
			ps.setString(2, userDTO.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String login;
				String name;
				String surname;
				String driverLicence;
				Integer idRole;

				login = rs.getString(2);
				name = rs.getString(4);
				surname = rs.getString(5);
				driverLicence = rs.getString(11);
				idRole = rs.getInt(12);
				
				customer1 = new CustomerTO(login, null, name, surname, null, null, null, null,
						null, driverLicence, idRole);
			}
			
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer1;
	}

	public AdminTO fetchAdmin(AdminTO admin, CustomerTOLP customerTOLP) {

		AdminTO admin1 = null;
		Select select = new QueryBuilder().selectFetchUser(new Admin(), customerTOLP, customerTOLP);
		System.out.println(select.getSelectQuery());

		try {
			connection = connector.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM admin where admin.login = ? and admin.password = ?");
			ps.setString(1, customerTOLP.getLogin());
			ps.setString(2, customerTOLP.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer adminId;
				String login;
				Integer roleId;

				adminId = rs.getInt(1);
				login = rs.getString(2);
				roleId = rs.getInt(4);
				System.out.println(login);

				admin1 = new AdminTO(adminId, login, roleId);
			}
			connector.putBack(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin1;
	}

	public CustomerTO makeCustomer(CustomerTO customerTO) {
			Customer cust = new Customer();
		try {
			Insert insert = new QueryBuilder().insert(customerTO, cust);
			System.out.println(insert.getInsertQuery());
			query.prepareStatement(insert.getInsertQuery()).executeUpdate();
			
			/*Customer customer;
			customer = (Customer) customerTO;
			customer.setCustomerId(17);
			System.out.println(customer);*/
			
			
			/*ResultSet generatedKeys;
			generatedKeys = query.prepareStatement(insert.getInsertQuery()).getGeneratedKeys();

			if (generatedKeys.next()) {
				//customer.setCustomerId(Integer.valueOf(generatedKeys.getInt(1)));		
			}
			customer.setRoleId(1);	*/
			
			connector.putBack(connection);
			
		} catch (SQLException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerTO;
	}
}






















