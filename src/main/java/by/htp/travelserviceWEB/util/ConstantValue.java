package by.htp.travelserviceWEB.util;

import java.util.LinkedList;
import java.util.List;

public final class ConstantValue {
	
	private ConstantValue(){}
	
	public static final String REQUEST_PARAM_ACTION = "action";
	
	public static final String PAGE_CATALOG_HOTEL = "/catalog_hotel.jsp";
	public static final String PAGE_CATALOG_AUTO = "/catalog_auto.jsp";
	public static final String PAGE_CATALOG_TOUR = "/catalog_tour.jsp";
	public static final List<String> listOfParametersForSinUp = new LinkedList<>();
	static {
		listOfParametersForSinUp.add("login");		
		listOfParametersForSinUp.add("password");
		listOfParametersForSinUp.add("name");
		listOfParametersForSinUp.add("surname");
		listOfParametersForSinUp.add("gender");
		listOfParametersForSinUp.add("birthday");
		listOfParametersForSinUp.add("passport");
		listOfParametersForSinUp.add("email");
		listOfParametersForSinUp.add("phone_number");
		listOfParametersForSinUp.add("driver_licence");
		listOfParametersForSinUp.add("password_repeat");
	}
	
	
}
