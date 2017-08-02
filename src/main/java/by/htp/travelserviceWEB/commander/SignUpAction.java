package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.ConstantValue.*;
import static by.htp.travelserviceWEB.util.Formatter.*;


public class SignUpAction implements CommandAction {

	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	private HttpSession httpSession;
	private CustomerTO customerTO;
	private Customer customer;
	private CustomerTOLP customerTOLP;
	private String page;
	
	private CustomerService customerService;

	public SignUpAction() {
		customerService = CustomerServiceImpl.getInstance();
		customer = new Customer();
		customerTO = new CustomerTO();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		customerTO = (CustomerTO) newInstance(request, customerTO);
        customerTO.setPassword(EncryptionFdl.encrypt(customerTO.getPassword()));
		        
        String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter(listOfParametersForSignUp.get(listOfParametersForSignUp.size() - 1)));
        
		if (!Validator.registrationCustomer(customerTO, passwordRepeatEncrypt)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			customerTOLP = new CustomerTOLP(customerTO.getLogin(), customerTO.getPassword());
			return getPage(request, response);
		}
	}

	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		httpSession = request.getSession();
		customer = customerService.authoriseCustomer(customerTOLP);	
		if (customer.getCustomerId() == null) {
			AdminTOWP adminTOWP = null;
			adminTOWP = customerService.authoriseAdmin(customerTOLP);
			if (adminTOWP.getAdminId() == null) {
				customer = customerService.registrationCustomer(this.customerTO);
				httpSession.setAttribute("user", this.customer);
				inputCookie(request, response);
				page = "jsp/home_page.jsp";
			}
			else {
				request.setAttribute("msg", "There is a user with such login.");
				page = "jsp/sign_up_page.jsp";
			}
		} else {
			request.setAttribute("msg", "There is a user with such login.");
			page = "jsp/sign_up_page.jsp";
		}
		//log.info("Sign up " + ((Customer)httpSession.getAttribute("user")).getLogin());
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customerTO.getLogin()));
		response.addCookie(new Cookie("password", this.customerTO.getPassword()));
	}
}