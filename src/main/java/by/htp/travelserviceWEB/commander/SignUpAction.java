package by.htp.travelserviceWEB.commander;

import java.sql.Date;

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

public class SignUpAction implements CommandAction {

private ServiceFactory serviceFactory;
	
	private Customer customer;
	private UserTO userDTO;

	public SignUpAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String login;
		String password;
		String name;
		String surname;
		String gender;
		String birthDate;
		Date birthday;
		String passport;
		String email;
		String phoneNumber;
		String driverLicence;
		Role role;
		
		password = Encryption.md5Apache(request.getParameter("password"));
		login = request.getParameter("login");
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		gender = request.getParameter("gender");
		birthDate = request.getParameter("birthday");
		passport = request.getParameter("passport");
		email = request.getParameter("email");
		phoneNumber = request.getParameter("phone_number");
		driverLicence = request.getParameter("driver_licence");

		birthday = Date.valueOf(birthDate);
		role = new Role(1, "customer");
		
		userDTO = new UserTO(login, password);
		customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, role);

		return getPage(request, response);

	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String page;
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
				Cookie cookiePass = new Cookie("password", request.getParameter("password"));
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