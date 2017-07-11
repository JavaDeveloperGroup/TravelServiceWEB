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

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.Encryption;
import by.htp.travelserviceWEB.util.Validator;

public class SignUpAction implements CommandAction {

private ServiceFactory serviceFactory;
	
	private HttpSession httpSession;
	private Customer customer;
	private UserTO userDTO;
	private String page;

	public SignUpAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		String repeatPassword;
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
		password = request.getParameter("password");
		repeatPassword = request.getParameter("repeat_password");
		passport = request.getParameter("passport");
		email = request.getParameter("email");
		phoneNumber = request.getParameter("phone_number");
		birthday = request.getParameter("birthday");
		gender = request.getParameter("gender");
		driverLicence = request.getParameter("driver_licence");
		
		if (!Validator.registrationCustomer(login, password, repeatPassword, name, surname, birthday, passport, email, phoneNumber)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			password = Encryption.base64Code(request.getParameter("password"));
			userDTO = new UserTO(login, password);
			customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email,
					phoneNumber, driverLicence, null);
			return getPage(request, response);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		Customer customer;
		httpSession = request.getSession();
		customer = serviceFactory.getUserService().authoriseCustomer(userDTO);	
		if (customer == null) {
			Admin admin = null;
			admin = serviceFactory.getUserService().authoriseAdmin(userDTO);
			if (admin == null) {
				customer = serviceFactory.getUserService().registrationCustomer(this.customer);
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
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookieLog = new Cookie("login", this.customer.getLogin());
		response.addCookie(cookieLog);
		Cookie cookiePass = new Cookie("password", Encryption.base64Code(request.getParameter("password")));
		response.addCookie(cookiePass);
	}
}