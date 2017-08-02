package by.htp.travelserviceWEB.util;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.auto.Auto;
import by.htp.travelserviceWEB.entity.auto.AutoOrder;
import by.htp.travelserviceWEB.entity.auto.BodyType;
import by.htp.travelserviceWEB.entity.auto.Color;
import by.htp.travelserviceWEB.entity.auto.RentAuto;
import by.htp.travelserviceWEB.entity.auto.Salon;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.delete.Delete;
import by.htp.travelserviceWEB.sqlbuilder.insert.Insert;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;
import by.htp.travelserviceWEB.sqlbuilder.update.Update;

public class TestClass {
	
	private AutoOrder autoOrder;
	private BodyType bodyType;
	private Color color;
	private RentAuto rentAuto;
	private Salon salon;
	
	public TestClass() {
		
		autoOrder = new AutoOrder();
		bodyType = new BodyType();
		color = new Color();
		rentAuto = new RentAuto();
		salon = new Salon();
	}
	
	public void test() {
		Auto insertAuto = new Auto(0, 3, "X5", "1999", "AUTO", "FULL", "PETROL", 3, 2, 
								   "http://res.cloudinary.com/javadevgroup/image/upload"
								   + "/v1497805554/auto/1969-Mustang-Pro-Street_tfthgb.jpg");
		
		Auto updateAuto = new Auto(17, 3, "Mustang", "1999", "AUTO", "FULL", "PETROL", 3, 2, 
								   "http://res.cloudinary.com/javadevgroup/image/upload"
								   + "/v1497805554/auto/1969-Mustang-Pro-Street_tfthgb.jpg");
		
		Auto deleteAuto = new Auto(12, 3, "X5", "1999", "AUTO", "FULL", "PETROL", 3, 2, 
								   "http://res.cloudinary.com/javadevgroup/image/upload"
								   + "/v1497805554/auto/1969-Mustang-Pro-Street_tfthgb.jpg");
		
		Customer customer = new Customer(1, "loginCust", "passwordCuss", 
										 "nameCuss", "surnameCuss", "MALE", 
										 "1988-04-17", "passportCuss", "emailCuss", 
										 "phone_numberCuss", "No", 1);
		
		Admin admin = new Admin(1, "loginAdmin", "passwordAdmin", 2);
		
		AdminTOWP adminTOWP = new AdminTOWP(1, "loginAdminTO", 1);
		
		CustomerTOLP customerTOLP = new CustomerTOLP("loginCustTOLP", "passwordCussTOLP");
		
		CustomerTO customerTO = new CustomerTO("loginCustTO", "passwordCussTO",
											   "nameCussTO", "surnameCussTO", "MALE",
											   "1988-04-17", "passportCussTO", "emailCussTO",
											   "phone_numberCussTO", "No", 1);
		
		Insert insert = null;
		Update update = null;
		Delete delete = null;
		Select selectAdmin = null;
		Select selectCustomer = null;
		
		try {
			insert = new QueryBuilder().insert(insertAuto).getQuery();
			update = new QueryBuilder().update(updateAuto).getQuery();
			delete = new QueryBuilder().delete(deleteAuto).getQuery();
			selectAdmin = new QueryBuilder().selectFetchUser(admin, customerTOLP).fetchCustomerOrAdmin();
			selectCustomer = new QueryBuilder().selectFetchUser(customerTO, customerTOLP).fetchCustomerOrAdmin();
			
			System.out.println(selectAdmin.toString());
			selectAdmin.resultSet(selectAdmin.toString());
			System.out.println("Success!");
			
			System.out.println(selectCustomer.toString());
			selectCustomer.resultSet(selectCustomer.toString());
			System.out.println("Success!");
			
			System.out.println(insert.toString());
			insert.prepareStatement(insert.toString()).executeUpdate();
			System.out.println("Success!");

			System.out.println(update.toString());
			update.prepareStatement(update.toString()).executeUpdate();
			System.out.println("Success!");

			System.out.println(delete.toString());
			delete.prepareStatement(delete.toString()).executeUpdate();
			System.out.println("Success!");
			
		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}	
		
		{
			Map<String, List<String>> conditionsAutoMap = new LinkedHashMap<>();
			List<String> transmition = new LinkedList<>();
			transmition.add("auto");
			List<String> wheelDrive = new LinkedList<>();
			wheelDrive.add("rear");
			wheelDrive.add("front");
			List<String> bodyType = new LinkedList<>();
			bodyType.add("sedan");
			bodyType.add("coupe");
			List<String> price = new LinkedList<>();
			price.add("100");
			price.add("500");
			conditionsAutoMap.put("transmition", transmition);
			conditionsAutoMap.put("wheel_drive", wheelDrive);
		}
	}
}
