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
import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class SignUpAction implements CommandAction, InputCookie {

	private CustomerService customerService;
	private static final Logger log = Logger.getLogger(SignUpAction.class);
	private String page;

	public SignUpAction() {
		customerService = CustomerServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerTO customerTO = (CustomerTO) newInstance(request, new CustomerTO());

		String passwordRepeat = request.getParameter("password_repeat");
		
		if (!Validator.dataRegistration(customerTO, passwordRepeat)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			customerTO.setPassword(EncryptionFdl.encrypt(passwordRepeat));
	
			return getPage(request, response, customerTO);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response, CustomerTO customerTO) {
		User customer;
		CustomerTOLP customerTOLP = new CustomerTOLP(customerTO.getLogin(), customerTO.getPassword());
		HttpSession httpSession = request.getSession();
		AdminTOWP adminTOWP = customerService.authoriseAdmin(customerTOLP);
		if (adminTOWP == null) {
			try {
				customer = customerService.registrationCustomer(customerTO);
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				createCookie(request, response, customer);
				log.info("Sign up Customer " + customer.getLogin());
				page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
				httpSession.setAttribute("originalPage",  null);
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
	
	/*private void inputCookie(HttpServletRequest request, HttpServletResponse response, User customer) {
		response.addCookie(new Cookie("log", customer.getLogin()));
		response.addCookie(new Cookie("passw", ((Customer)customer).getPassword()));
	}*/
}