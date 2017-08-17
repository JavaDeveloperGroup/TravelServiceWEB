package by.htp.travelserviceWEB.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ConstantValue {
	
	private ConstantValue(){}
	
	public static final String REQUEST_PARAM_ACTION = "command";
	
	public static final String PAGE_CATALOG_HOTEL = "/catalog_hotel.jsp";
	public static final String PAGE_CATALOG_AUTO = "/catalog_auto.jsp";
	public static final String PAGE_CATALOG_TOUR = "/catalog_tour.jsp";
	public static final String PAGE_HOME = "jsp/home_page.jsp";
	public static final String SESSION_ATTRIBUTE_USER = "user";
	public static final String REQUEST_ATTRIBUTE_MSG = "msg";

	public static final Map<String, List<String>> allListsParameters = new ConcurrentHashMap<String, List<String>>();
	//private static final List<String> listOfParametersForSignUp = new LinkedList<>();
	static {
		List<String> parametersForSignUp = new LinkedList<>();
		parametersForSignUp.add("login");		
		parametersForSignUp.add("password");
		parametersForSignUp.add("name");
		parametersForSignUp.add("surname");
		parametersForSignUp.add("gender");
		parametersForSignUp.add("birthday");
		parametersForSignUp.add("passport");
		parametersForSignUp.add("email");
		parametersForSignUp.add("phone_number");
		parametersForSignUp.add("driver_licence");
		parametersForSignUp.add("id_role");
		allListsParameters.put("customerto", parametersForSignUp);
	}
	//public static final List<String> listOfParametersForLogIn = new LinkedList<>();
	static {
		List<String> parametersForLogIn = new LinkedList<>();
		parametersForLogIn.add("login");		
		parametersForLogIn.add("password");
		allListsParameters.put("customertolp", parametersForLogIn);
	}
	//public static final List<String> listOfParametersForUpdateData = new LinkedList<>();
	static {	
		List<String> parametersForUpdateData = new LinkedList<>();
		parametersForUpdateData.add("new_password");
		parametersForUpdateData.add("gender");
		parametersForUpdateData.add("birthday");
		parametersForUpdateData.add("email");
		parametersForUpdateData.add("phone_number");
		parametersForUpdateData.add("driver_licence");
		allListsParameters.put("customertoupdate", parametersForUpdateData);
	}
	
}
