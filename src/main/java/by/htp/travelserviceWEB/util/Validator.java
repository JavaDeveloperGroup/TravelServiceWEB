package by.htp.travelserviceWEB.util;

import java.util.regex.Pattern;

/**
 * The class checks all input information
 */

public class Validator {
	
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
     * @param name         STRING_REGEX
     * @param surname      STRING_REGEX
     * @param passport     PASSPORT_REGEX
     * @param email        EMAIL_REGEX
     * @param phoneNumber  PHONE_NUMBER_REGEX
     * @return boolean true, if the information is correct
     */
    
    public static boolean registrationCustomer(String login, String password, String name, String surname, String passport, String email, String phoneNumber) {
    	if(null != login && null != password && null != name && null != surname && null != passport
                && null != email && null != phoneNumber) {
    		boolean b = Pattern.matches(LOGIN_REGEX, login)
                    && Pattern.matches(PASSWORD_REGEX, password)
                    && Pattern.matches(STRING_REGEX, name)
                    && Pattern.matches(STRING_REGEX, surname)
                    && Pattern.matches(EMAIL_REGEX, email)
                    && Pattern.matches(PASSPORT_REGEX, passport)
                    && Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    		return b;
    	}
    	else
    		return false;
    }
}

