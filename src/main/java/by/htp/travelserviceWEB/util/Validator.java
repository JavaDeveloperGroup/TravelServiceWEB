package by.htp.travelserviceWEB.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.entity.dto.CustomerTOUpdate;

/**
 * The class checks all input information
 */

public class Validator {
	
	private static final String FORMAT = ("yyyy-MM-dd");
	
	private Validator(){}
	
	private static final String LOGIN_REGEX = "[A-z0-9]{3,20}";
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*]).{8,100})";
	private static final String STRING_REGEX = "[A-Z]{1}[a-z]{0,100}";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9.,_%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,4}$";
    private static final String PASSPORT_REGEX = "[A-Z]{2}[0-9]{7}";
    private static final String PHONE_NUMBER_REGEX = "[\\+]{1}[0-9]{2,4}[0-9]+";
        
    /**
     * Checks input information for a new user account
     *
     * @param login        LOGIN_REGEX
     * @param password     PASSWORD_REGEX
     * @param password
     * @param name         STRING_REGEX
     * @param surname      STRING_REGEX
     * @param birthday
     * @param passport     PASSPORT_REGEX
     * @param email        EMAIL_REGEX
     * @param phoneNumber  PHONE_NUMBER_REGEX
     * @return boolean true, if the information is correct
     * @throws IOException 
     * @throws ServletException 
     */
    
    public static boolean dataRegistration(Entity entity, String repeatPassword) 
    		throws ServletException, IOException {
    	
    	if(entity instanceof CustomerTO) {
    		CustomerTO customer = (CustomerTO)entity;
    		if (!customer.getPassword().equals(repeatPassword) | !checkDate(customer.getBirthday())) {
    			return false;
    		} else if (null != customer.getLogin() && null != customer.getPassword() 
    					&& null != customer.getName() && null != customer.getSurname() 
    					&& null != customer.getPassport() && null != customer.getEmail() 
    					&& null != customer.getPhoneNumber()) {
    			
        		return Pattern.matches(LOGIN_REGEX, customer.getLogin())
                        && Pattern.matches(PASSWORD_REGEX, customer.getPassword())
                        && Pattern.matches(STRING_REGEX, customer.getName())
                        && Pattern.matches(STRING_REGEX, customer.getSurname())
                        && Pattern.matches(EMAIL_REGEX, customer.getEmail())
                        && Pattern.matches(PASSPORT_REGEX, customer.getPassport())
                        && Pattern.matches(PHONE_NUMBER_REGEX, customer.getPhoneNumber());
        		
        	} else {
        		return false;
        	}
    		
    	} else if (entity instanceof CustomerTOUpdate){
    		CustomerTOUpdate customer = (CustomerTOUpdate)entity;
    		if (!customer.getPassword().equals(repeatPassword) | !checkDate(customer.getBirthday())) {
    			return false;
    		} else if (null != customer.getPassword() && null != customer.getEmail() 
    					&& null != customer.getPhoneNumber()) {
    			
        		return Pattern.matches(PASSWORD_REGEX, customer.getPassword())
                        && Pattern.matches(EMAIL_REGEX, customer.getEmail())
                        && Pattern.matches(PHONE_NUMBER_REGEX, customer.getPhoneNumber());
        		
        	} else {
        		return false;
        	}
    	} else
    		return false;
    	
    }
    
    private static boolean checkDate(String birthday) throws ServletException, IOException {
    	long birthTimeMillis = 0;
		long todayTimeMillis = 0;
    	
    	SimpleDateFormat formater = new SimpleDateFormat(FORMAT);
		
		try {
			birthTimeMillis = formater.parse(birthday).getTime();
			todayTimeMillis = Clock.systemDefaultZone().millis();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		if (((18 * 365) + 4) > Math.abs((todayTimeMillis - birthTimeMillis) / (1000 * 60 * 60 * 24)) && birthTimeMillis < todayTimeMillis) {
			return false;
		} else 
			return true;
	}
    
    public static boolean dataAuthorisation(CustomerTOLP customerTOLP) {
    	if (null != customerTOLP.getLogin() && null != customerTOLP.getPassword())
    		return Pattern.matches(LOGIN_REGEX, customerTOLP.getLogin())
    				&& Pattern.matches(PASSWORD_REGEX, customerTOLP.getPassword()); 
    	else
    		return false;
    }
}

