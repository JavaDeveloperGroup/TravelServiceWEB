package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Customer;
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
	private String page;;
	
	public LogInAction() {
		customerService = CustomerServiceImpl.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		CustomerTOLP customerTOLP = (CustomerTOLP) newInstance(request, new CustomerTOLP());	
		
		if(!Validator.checkForCorrentInputDataAuthoriseUser(customerTOLP)) {
			page = "jsp/log_in_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		} else 
			customerTOLP.setPassword(EncryptionFdl.encrypt(customerTOLP.getPassword()));
			return authorisationUser(request, response, customerTOLP);
	}
	
	private String authorisationUser(HttpServletRequest request, HttpServletResponse response, CustomerTOLP customerTOLP) {
		HttpSession httpSession = request.getSession();

		User user = customerService.authoriseCustomer(customerTOLP);

		if (user == null) {
			user = customerService.authoriseAdmin(customerTOLP);
			if (user == null) {
				request.setAttribute(REQUEST_ATTRIBUTE_MSG, "There is no user with such login.");
				page = "jsp/log_in_page.jsp";
				return page;
			}
		} else {
			// input data in Cookie
			createCookie(request, response, user);		
		}
		httpSession.setAttribute("user", user);
		page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
		httpSession.setAttribute("originalPage", null);
		log.info("Log in " + getRoleName(user) + " " + customerTOLP.getLogin());
		//request.setAttribute("user", httpSession.getAttribute("user"));
		return page;
	}
	
	/*private void inputCookie(HttpServletRequest request, HttpServletResponse response, User user) {
		response.addCookie(new Cookie("log", user.getLogin()));
		response.addCookie(new Cookie("passw", ((Customer)user).getPassword()));
	}*/
}