package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.EncryptionApache;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.Validator;

public class SignUpAction implements CommandAction {

	private ServiceFactory serviceFactory;
	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	private HttpSession httpSession;
	private Customer customer;
	private UserTO userTO;
	private String page;

	public SignUpAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		String passwordRepeat;
		String name;
		String surname;
		String gender;
		String birthday;
		String passport;
		String email;
		String phoneNumber;
		String driverLicence;
		login = request.getParameter("login");
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		password = EncryptionFdl.encrypt(request.getParameter("password"));
		passwordRepeat = EncryptionFdl.encrypt(request.getParameter("password_repeat"));
		passport = request.getParameter("passport");
		email = request.getParameter("email");
		phoneNumber = request.getParameter("phone_number");
		birthday = request.getParameter("birthday");
		gender = request.getParameter("gender");
		driverLicence = request.getParameter("driver_licence");
		
		if (!Validator.registrationCustomer(login, password, passwordRepeat, name, surname, birthday, passport, email, phoneNumber)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			//create userTO
			userTO = new UserTO(login, password);
			
			customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email,
					phoneNumber, driverLicence, null);
			return getPage(request, response);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		Customer customer;
		httpSession = request.getSession();
		customer = serviceFactory.getUserService().authoriseCustomer(userTO);	
		if (customer == null) {
			Admin admin = null;
			admin = serviceFactory.getUserService().authoriseAdmin(userTO);
			if (admin == null) {
				customer = serviceFactory.getUserService().registrationCustomer(this.customer);
				httpSession.setAttribute("user", this.customer);
				//input data in Cookie
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
		log.info("Sign up " + ((Customer)httpSession.getAttribute("user")).getLogin());
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookieLog = new Cookie("login", this.customer.getLogin());
		response.addCookie(cookieLog);
		Cookie cookiePass = new Cookie("password", EncryptionFdl.encrypt(request.getParameter("password")));
		response.addCookie(cookiePass);
	}
}