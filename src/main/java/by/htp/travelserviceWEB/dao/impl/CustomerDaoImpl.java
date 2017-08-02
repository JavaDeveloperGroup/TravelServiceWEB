package by.htp.travelserviceWEB.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travelserviceWEB.connector.ConnectionPool;
import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
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

	public Customer fetchCustomer(CustomerTOLP customerTOLP) {	
		Customer customer = new Customer();

		try {
			Select select = new QueryBuilder().selectFetchUser(customer, customerTOLP).fetchCustomerOrAdmin();
			ResultSet rs = select.resultSet(select.toString());

			customer = (Customer)query.getInstanceWithDataFromSQL(rs, customer);

		} catch (SecurityException | ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return customer;
		
	}

	public AdminTOWP fetchAdmin(CustomerTOLP customerTOLP) {
		AdminTOWP adminTOWP = new AdminTOWP();
		
		try {
			Select select = new QueryBuilder().selectFetchUser(adminTOWP, customerTOLP).fetchCustomerOrAdmin();
			System.out.println(select.toString());
			ResultSet rs = select.resultSet(select.toString());
			
			
			adminTOWP = (AdminTOWP)query.getInstanceWithDataFromSQL(rs, adminTOWP);	
			    
		} catch (SecurityException | ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return adminTOWP;
	}

	public Customer makeCustomer(CustomerTO customerTO) {	
		Admin admin = new Admin();
		Customer customer = new Customer();
		Insert insert = null;
		try {
			insert = new QueryBuilder().insert(customerTO).getQuery();
		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(insert.toString());
		try (PreparedStatement preparedStatement = query.prepareStatement(insert.toString())){	
			
			preparedStatement.executeUpdate();
			
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
			
		} catch (SQLException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
}






















