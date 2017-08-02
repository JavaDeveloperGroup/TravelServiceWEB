package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.ConstantValue.*;
import static by.htp.travelserviceWEB.util.Formatter.*;

public class SignUpAction implements CommandAction {

	private CustomerServiceImpl customerService;
	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	private HttpSession httpSession;
	private CustomerTO customerTO;
	private Customer customer;
	private CustomerTOLP customerTOLP;
	private String page;

	public SignUpAction() {
		customerService = CustomerServiceImpl.getInstance();
		customer = new Customer();
		customerTO = new CustomerTO();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerTO = (CustomerTO)newInstance(request, customerTO);
		customerTO.setPassword(EncryptionFdl.encrypt(customerTO.getPassword()));
		          
		String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter(listOfParametersForSignUp.get(listOfParametersForSignUp.size() - 1)));
		
		if (!Validator.registrationCustomer(customerTO, passwordRepeatEncrypt)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			//create customerTOLP
			customerTOLP = new CustomerTOLP(customerTO.getLogin(), customerTO.getPassword());
			return getPage(request, response);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		httpSession = request.getSession();
		AdminTOWP adminTOWP;
		adminTOWP = customerService.authoriseAdmin(customerTOLP);
		if (adminTOWP == null) {
			try {
				customer = customerService.registrationCustomer(this.customerTO);
			} catch (MySQLIntegrityConstraintViolationException e) {
				return getPageOnErrorInputData(request);
			}
			
			httpSession.setAttribute("user", this.customer);
			// input data in Cookie
			inputCookie(request, response);
			log.info("Sign up " + this.customer.getLogin());
			page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
			httpSession.setAttribute("originalPage",  null);
		} else {
			page = getPageOnErrorInputData(request);
		}
		return page;
	}
	
	private String getPageOnErrorInputData(HttpServletRequest request){
		request.setAttribute("msg", "There is a user with such login.");
		page = "jsp/sign_up_page.jsp";
		log.info("Sign up is fail " + this.customer.getLogin());
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("log", this.customer.getLogin()));
		response.addCookie(new Cookie("passw", this.customer.getPassword()));
	}
}