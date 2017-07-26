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
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.Validator;

public class UpdateAccountAction implements CommandAction {

	private ServiceFactory serviceFactory;
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private Customer customer;

	public UpdateAccountAction() {
		serviceFactory = ServiceFactory.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page;
		
		System.out.println(request.getHeader("referer"));
		
		HttpSession httpSession = request.getSession();
		UserTO userTO;
		
		String login = request.getParameter("login");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = EncryptionFdl.encrypt(request.getParameter("password"));
		String passwordRepeat = EncryptionFdl.encrypt(request.getParameter("password_repeat"));
		String passport = request.getParameter("passport");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone_number");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String driverLicence = request.getParameter("driver_licence");
		
		if (!Validator.registrationCustomer(login, password, passwordRepeat, name, surname, birthday, passport, email, phoneNumber)) {
			page = "jsp/update_account_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			//create userTO
			userTO = new UserTO(login, password);
			
			customer = new Customer(((Customer)httpSession.getAttribute("user")).getCustomerId(), login, password, name, surname, gender, birthday, passport, email,
					phoneNumber, driverLicence, ((Customer)httpSession.getAttribute("user")).getIdRole());
			try {
				serviceFactory.getUserService().updateAccountCustomer(customer);
				httpSession.setAttribute("user", customer);
				// input data in Cookie
				inputCookie(request, response);
				page = "jsp/home_page.jsp";
				log.info("Update account " + customer.getLogin());
				return page;
			}
			catch (SQLException e) {
				page = "jsp/update_account_page.jsp";
				request.setAttribute("msg", "There is a user with such data.");
				log.info("Update account is fail " + ((Customer)httpSession.getAttribute("user")).getLogin());
				return page;
			}
		}
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customer.getLogin()));
		response.addCookie(new Cookie("password", this.customer.getPassword()));
	}
}
