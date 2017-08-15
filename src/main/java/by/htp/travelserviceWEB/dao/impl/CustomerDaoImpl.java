package by.htp.travelserviceWEB.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import by.htp.travelserviceWEB.dao.CustomerDao;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.insert.Insert;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;
import by.htp.travelserviceWEB.sqlbuilder.update.Update;

public class CustomerDaoImpl implements CustomerDao {

	private CustomerDaoImpl() {}

	private static class Singletone {
		private static final CustomerDaoImpl INSTANCE = new CustomerDaoImpl();
	}

	public static CustomerDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Customer fetchCustomer(CustomerTOLP customerTOLP) {	
		Customer customer = new Customer();

		try {
			Select select = new QueryBuilder().selectFetchUser(customer, customerTOLP).fetchCustomerOrAdmin();
			ResultSet rs = select.resultSet(select.toString());

			customer = (Customer)select.getInstanceWithDataFromSQL(rs, customer);

		} catch (SecurityException | ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return customer;
		
	}
	
	@Override
	public AdminTOWP fetchAdmin(CustomerTOLP customerTOLP) {
		AdminTOWP adminTOWP = new AdminTOWP();
		
		try {
			Select select = new QueryBuilder().selectFetchUser(adminTOWP, customerTOLP).fetchCustomerOrAdmin();
			ResultSet rs = select.resultSet(select.toString());
					
			adminTOWP = (AdminTOWP)select.getInstanceWithDataFromSQL(rs, adminTOWP);				
			    
		} catch (SecurityException | ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return adminTOWP;
	}
	
	@Override
	public Customer makeCustomer(CustomerTO customerTO) throws MySQLIntegrityConstraintViolationException{	
		Customer customer = new Customer();
		Insert insert = null;
		try {
			insert = new QueryBuilder().insert(customerTO).getQuery();
		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try (PreparedStatement preparedStatement = insert.prepareStatement(insert.toString())){	
			
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				customer.setCustomerId(generatedKeys.getInt(1));
			}
			
		} catch (SQLException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			if(e instanceof MySQLIntegrityConstraintViolationException)
				throw new MySQLIntegrityConstraintViolationException();
		}
		
		return customer;
	}

	@Override
	public Customer updateAccountCustomer(Customer customer) throws MySQLIntegrityConstraintViolationException {

		//"UPDATE `travelservice`.`customer` SET `password`=?, `name`=?, `surname`=?, `gender`=?, `birthday`=?, `passport`=?, `email`=?, `phone_driver`=?, `driver_licence`=? WHERE `id_customer`=?;");
		try {
			Update update = new QueryBuilder().update(customer).getQuery();
			System.out.println(update.toString());
			try (PreparedStatement preparedStatement = update.prepareStatement(update.toString())) {
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
}






















