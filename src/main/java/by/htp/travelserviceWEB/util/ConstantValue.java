package by.htp.travelserviceWEB.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ConstantValue {
	
	private ConstantValue(){}
	
	public static final String REQUEST_PARAM_ACTION = "action";
	
	public static final String PAGE_CATALOG_HOTEL = "/catalog_hotel.jsp";
	public static final String PAGE_CATALOG_AUTO = "/catalog_auto.jsp";
	public static final String PAGE_CATALOG_TOUR = "/catalog_tour.jsp";
	public static final Map<String, List<Object>> allListsParameters = new ConcurrentHashMap<String, List<Object>>();
	//private static final List<String> listOfParametersForSignUp = new LinkedList<>();
	static {
		List<Object> listOfParametersForSignUp = new LinkedList<>();
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
		listOfParametersForSignUp.add("id_role");
		allListsParameters.put("customerto", listOfParametersForSignUp);
	}
	//public static final List<String> listOfParametersForLogIn = new LinkedList<>();
	static {
		List<Object> listOfParametersForLogIn = new LinkedList<>();
		listOfParametersForLogIn.add("login");		
		listOfParametersForLogIn.add("password");
		allListsParameters.put("customertolp", listOfParametersForLogIn);
	}
	//public static final List<String> listOfParametersForUpdateData = new LinkedList<>();
	static {	
		List<Object> listOfParametersForUpdateData = new LinkedList<>();
		listOfParametersForUpdateData.add("new_password");
		listOfParametersForUpdateData.add("gender");
		listOfParametersForUpdateData.add("birthday");
		listOfParametersForUpdateData.add("email");
		listOfParametersForUpdateData.add("phone_number");
		listOfParametersForUpdateData.add("driver_licence");
		allListsParameters.put("customertoupdate", listOfParametersForUpdateData);
	}
	
}
