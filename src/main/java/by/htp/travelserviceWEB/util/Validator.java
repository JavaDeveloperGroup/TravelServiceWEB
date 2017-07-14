package by.htp.travelserviceWEB.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
    
    public static boolean registrationCustomer(String login, String password, String passwordRepeat, String name, String surname, String birthday, String passport, String email, String phoneNumber) throws ServletException, IOException {
    	String passw = EncryptionFdl.decrypt(password);
    	if (!passw.equals(EncryptionFdl.decrypt(passwordRepeat))) {
			return false;
		}
		else if (!checkDate(birthday)) {
			return false;
		}
		else if(null != login && null != password && null != name && null != surname && null != passport
                && null != email && null != phoneNumber) {
    		return Pattern.matches(LOGIN_REGEX, login)
                    && Pattern.matches(PASSWORD_REGEX, passw)
                    && Pattern.matches(STRING_REGEX, name)
                    && Pattern.matches(STRING_REGEX, surname)
                    && Pattern.matches(EMAIL_REGEX, email)
                    && Pattern.matches(PASSPORT_REGEX, passport)
                    && Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    	}
    	else {
    		return false;
    	}
    }
    
    private static boolean checkDate(String birthday) throws ServletException, IOException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		long d1 = 0;
		long d2 = 0;
		try {
			d1 = formater.parse(birthday).getTime();
			d2 = formater.parse(formater.format(new Date())).getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (((18 * 365) + 4) > Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) && d1 < d2) {
			return false;
		}
		else 
			return true;
	}
}

