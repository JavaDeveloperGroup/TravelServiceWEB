package by.htp.travelserviceWEB.util;

import java.util.LinkedList;
import java.util.List;

public final class ConstantValue {
	
	private ConstantValue(){}
	
	public static final String REQUEST_PARAM_ACTION = "action";
	
	public static final String PAGE_CATALOG_HOTEL = "/catalog_hotel.jsp";
	public static final String PAGE_CATALOG_AUTO = "/catalog_auto.jsp";
	public static final String PAGE_CATALOG_TOUR = "/catalog_tour.jsp";
	public static final List<String> listOfParametersForSignUp = new LinkedList<>();
	static {
		listOfParametersForSignUp.add("login");		
		listOfParametersForSignUp.add("password");
		listOfParametersForSignUp.add("name");
		listOfParametersForSignUp.add("surname");
		listOfParametersForSignUp.add("gender");
		listOfParametersForSignUp.add("birthday");
		listOfParametersForSignUp.add("passport");
		listOfParametersForSignUp.add("email");
		listOfParametersForSignUp.add("phone_number");
		listOfParametersForSignUp.add("driver_licence");
		listOfParametersForSignUp.add("password_repeat");
	}
	
	
}
