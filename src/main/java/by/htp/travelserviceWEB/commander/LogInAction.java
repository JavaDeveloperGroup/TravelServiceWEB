package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.Formatter.*;
import static by.htp.travelserviceWEB.util.ConstantValue.*;

public final class LogInAction implements CommandAction, InputCookie {
	
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private CustomerService customerService;
	
	public LogInAction() {
		customerService = CustomerServiceImpl.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		HttpSession httpSession = request.getSession();
		CustomerTOLP customerTOLP = (CustomerTOLP) newInstance(request, new CustomerTOLP());	
		if(!Validator.dataAuthorisation(customerTOLP))	{
			request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Incorrect data entry.");
			return PAGE_LOG_IN;
		}
		customerTOLP.setPassword(EncryptionFdl.encrypt(customerTOLP.getPassword()));
		User user = customerService.authoriseCustomer(customerTOLP);
		if(user == null) {
			user = customerService.authoriseAdmin(customerTOLP);
			if(user == null) {
				request.setAttribute(REQUEST_ATTRIBUTE_MSG, "There is no user with such login or password.");	
				return PAGE_LOG_IN;
			}
		} else {
			//input data in Cookie
			createCookie(request, response, user);
		}
		httpSession.setAttribute("user", user);
		httpSession.setAttribute(ORIGINAL_PAGE, null);
		log.info("Log in " + getRoleName(user) + " " + customerTOLP.getLogin());
		return ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
	}
}