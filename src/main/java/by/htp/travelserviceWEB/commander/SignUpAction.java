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
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class SignUpAction implements CommandAction {

	private CustomerService customerService;
	private static final Logger log = Logger.getLogger(SignUpAction.class);
	
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
		customerTO = (CustomerTO) newInstance(request, customerTO);
		//customerTO.setPassword(EncryptionFdl.encrypt(customerTO.getPassword()));
		          
		//String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter(listOfParametersForSignUp.get(listOfParametersForSignUp.size() - 1)));
		String passwordRepeat = request.getParameter("password_repeat");
		
		if (!Validator.checkForCorrentInputDataCustomer(customerTO, passwordRepeat)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			customerTO.setPassword(EncryptionFdl.encrypt(customerTO.getPassword()));
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
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				inputCookie(request, response);
				log.info("Sign up " + customer.getLogin());
				page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
				httpSession.setAttribute("originalPage",  null);
				request.setAttribute("user", customer);
			} catch (MySQLIntegrityConstraintViolationException e) {
				log.info("Sign up is fail " + e.toString());
				page = getPageOnErrorInputData(request);
			}
		} else {
			log.info("Sign up is fail");
			page = getPageOnErrorInputData(request);
		}
		return page;
	}
	
	private String getPageOnErrorInputData(HttpServletRequest request){
		request.setAttribute("msg", "There is a user with such data.");
		page = "jsp/sign_up_page.jsp";
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("log", this.customer.getLogin()));
		response.addCookie(new Cookie("passw", this.customer.getPassword()));
	}
}