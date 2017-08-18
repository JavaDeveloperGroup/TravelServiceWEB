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
import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.CustomerTOUpdate;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.Formatter.*;
import static by.htp.travelserviceWEB.util.ConstantValue.*;

public class UpdateAccountAction implements CommandAction, InputCookie {

	private CustomerService customerService;
	private static final Logger log = Logger.getLogger(UpdateAccountAction.class);
	private User customer;
	private CustomerTOUpdate customerTOUpdate;

	public UpdateAccountAction() {
		customerService = CustomerServiceImpl.getInstance();
		customerTOUpdate = new CustomerTOUpdate();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;
		HttpSession httpSession = request.getSession();
		customer = (User)httpSession.getAttribute("user");
		
		customerTOUpdate = (CustomerTOUpdate) newInstance(request, customerTOUpdate);
		
		String oldPassword = EncryptionFdl.encrypt(request.getParameter("old_password"));
		String passwordRepeat = request.getParameter("password_repeat");
		
		if (oldPassword.equals(((Customer)customer).getPassword())) {
			if (!Validator.checkForCorrentInputDataCustomer(customerTOUpdate, passwordRepeat)) {
				page = "jsp/update_account_page.jsp";
				request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Incorrect data entry.");
				return page;
			} else {
				((Customer)customer).updateData(customerTOUpdate);
				try {
					customerService.updateAccountCustomer((Customer)customer);
				} catch (SQLException e) {
					page = "jsp/update_account_page.jsp";
					request.setAttribute(REQUEST_ATTRIBUTE_MSG, "There is a user with such data.");
					log.info("Update account is fail " + customer.getLogin());
				}
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				createCookie(request, response, customer);
				
				page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
				log.info("Update account Customer " + customer.getLogin());
				return page;
			}
		} else {
			page = "jsp/update_account_page.jsp";
			request.setAttribute(REQUEST_ATTRIBUTE_MSG, "Invalid old password entered.");
			return page;
		}
	}
	
	/*private void inputCookie(HttpServletRequest request, HttpServletResponse response, User customer) {
		response.addCookie(new Cookie("login", this.customer.getLogin()));
		response.addCookie(new Cookie("password", ((Customer)customer).getPassword()));
	}*/
}
