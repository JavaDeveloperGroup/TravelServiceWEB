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
		Role role;
		login = request.getParameter("login");
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		password = request.getParameter("password");
		repeatPassword = request.getParameter("repeat_password");
		passport = request.getParameter("passport");
		email = request.getParameter("email");
		phoneNumber = request.getParameter("phone_number");
		birthday = request.getParameter("birthday");
		
		if (!password.equals(repeatPassword)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Repeat password incorrectly.");
			return page;
		}
		else if (!checkDate(request)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect date entry.");
			return page;
		}
		else if (!Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			password = Encryption.base64Code(request.getParameter("password"));
			gender = request.getParameter("gender");
			driverLicence = request.getParameter("driver_licence");
			role = new Role(1, "customer");
			userDTO = new UserTO(login, password);
			customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email,
					phoneNumber, driverLicence, role);
			return getPage(request, response);
		}
	}
	
	private boolean checkDate(HttpServletRequest request) throws ServletException, IOException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		long d1 = 0;
		long d2 = 0;
		try {
			d1 = formater.parse(request.getParameter("birthday")).getTime();
			d2 = formater.parse(formater.format(new Date())).getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (((18 * 365) + 4) > Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) && d1 < d2) {
			return false;
		}
		else 
			return true;
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		Customer customer;
		HttpSession httpSession = request.getSession();
		customer = serviceFactory.getUserService().authoriseCustomer(userDTO);	
		if (customer == null) {
			Admin admin = null;
			admin = serviceFactory.getUserService().authoriseAdmin(userDTO);
			if (admin == null) {
				customer = serviceFactory.getUserService().registrationCustomer(this.customer);
				httpSession.setAttribute("customer", this.customer);
				Cookie cookieLog = new Cookie("login", this.customer.getLogin());
				response.addCookie(cookieLog);
				Cookie cookiePass = new Cookie("password", Encryption.base64Code(request.getParameter("password")));
				response.addCookie(cookiePass);
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
}