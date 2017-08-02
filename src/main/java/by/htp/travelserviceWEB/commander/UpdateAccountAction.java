package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.entity.dto.CustomerTOUpdate;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.ConstantValue.*;
import static by.htp.travelserviceWEB.util.Formatter.*;

public class UpdateAccountAction implements CommandAction {

	private CustomerService customerService;
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private Customer customer;
	private CustomerTOUpdate customerTOUpdate;

	public UpdateAccountAction() {
		customerService = CustomerServiceImpl.getInstance();
		customerTOUpdate = new CustomerTOUpdate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;
		CustomerTOLP customerTOLP;
		HttpSession httpSession = request.getSession();
		Customer customer = (Customer)httpSession.getAttribute("user");
		Customer copyCustomer = null;
		try {
			copyCustomer = (Customer) customer.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		//copyCustomer = 
		
		String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter(listOfParametersForSignUp.get(listOfParametersForSignUp.size() - 1)));
		
		if (!Validator.registrationCustomer(customerTOUpdate, passwordRepeatEncrypt)) {
			page = "jsp/update_account_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			try {
				customerService.updateAccountCustomer(customer);
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				inputCookie(request, response);
				page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
				log.info("Update account " + customer.getLogin());
			}
			catch (SQLException e) {
				page = "jsp/update_account_page.jsp";
				request.setAttribute("msg", "There is a user with such data.");
				log.info("Update account is fail " + ((Customer)httpSession.getAttribute("user")).getLogin());
			}
		}
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customer.getLogin()));
		response.addCookie(new Cookie("password", this.customer.getPassword()));
	}
}
