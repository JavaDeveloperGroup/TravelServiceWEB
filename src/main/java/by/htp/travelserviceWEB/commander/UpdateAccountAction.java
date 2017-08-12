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

import static by.htp.travelserviceWEB.util.Formatter.*;

public class UpdateAccountAction implements CommandAction {

	private CustomerService customerService;
	private static final Logger log = Logger.getLogger(UpdateAccountAction.class);
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
		customer = (Customer)httpSession.getAttribute("user");
		//Customer copyCustomer = null;
		customerTOUpdate = (CustomerTOUpdate) newInstance(request, customerTOUpdate);
		
		/*try {
			copyCustomer = (Customer) customer.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}*/
		String oldPassword = EncryptionFdl.encrypt(request.getParameter("old_password"));
		String passwordRepeat = request.getParameter("password_repeat");
		
		if (oldPassword.equals(customer.getPassword())) {
			if (!Validator.checkForCorrentInputDataCustomer(customerTOUpdate, passwordRepeat)) {
				page = "jsp/update_account_page.jsp";
				request.setAttribute("msg", "Incorrect data entry.");
				return page;
			} else {
				customer.setPassword(EncryptionFdl.encrypt(customerTOUpdate.getPassword()));
				customer.setGender(customerTOUpdate.getGender());
				customer.setBirthday(customerTOUpdate.getBirthday());
				customer.setEmail(customerTOUpdate.getEmail());
				customer.setPhoneNumber(customerTOUpdate.getPhoneNumber());
				customer.setDriverLicence(customerTOUpdate.getDriverLicence());
				try {
					customerService.updateAccountCustomer(customer);
				} catch (SQLException e) {
					page = "jsp/update_account_page.jsp";
					request.setAttribute("msg", "There is a user with such data.");
					log.info("Update account is fail " + customer.getLogin());
				}
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				inputCookie(request, response);
				page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
				log.info("Update account " + customer.getLogin());
				return page;
			}
		} else {
			page = "jsp/update_account_page.jsp";
			request.setAttribute("msg", "Invalid old password entered.");
			return page;
		}
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customer.getLogin()));
		response.addCookie(new Cookie("password", this.customer.getPassword()));
	}
}
