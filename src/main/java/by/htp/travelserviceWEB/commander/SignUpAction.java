package by.htp.travelserviceWEB.commander;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;
import by.htp.travelserviceWEB.util.Encryption;

public class SignUpAction implements CommandAction {

	private UserService userService;
	
	private Customer customer;
	private UserDTO userDTO;

	public SignUpAction() {
		userService = UserServiceImpl.getInstance();
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
		String driverLicense;
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
		driverLicense = request.getParameter("driver_license");

		birthday = Date.valueOf(birthDate);
		role = new Role(1, "customer");
		
		userDTO = new UserDTO(login, password);
		customer = new Customer(null, login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicense, role);

		return getPage(request, response);

	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		String page;
		
		HttpSession httpSession = request.getSession();
		
		customer = userService.authoriseCustomer(userDTO);	
		
		if (customer == null) {
			Admin admin = null;
			admin = userService.authoriseAdmin(userDTO);
			if (admin == null) {
				
				customer = userService.registrationCustomer(customer);
				
				httpSession.setAttribute("customer", customer);

				Cookie cookieLog = new Cookie("login", customer.getLogin());
				response.addCookie(cookieLog);
				Cookie cookiePass = new Cookie("password", request.getParameter("password"));
				response.addCookie(cookiePass);

				page = "jsp/catalog_hotel_page.jsp";
				
			}
			else {
				request.setAttribute("msg", "There is a user with such login.");
				page = "jsp/signup_page.jsp";
			}
		} else {
			request.setAttribute("msg", "There is a user with such login.");
			page = "jsp/signup_page.jsp";
		}
		
		return page;
	}
	

}
