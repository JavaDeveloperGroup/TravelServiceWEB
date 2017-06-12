package by.htp.travelserviceWEB.commander;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;

public class SignUp implements CommandAction{
	
	private UserService userService;
	
	public SignUp() {
		userService = UserServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		HttpSession httpSession;
		
		Customer customer = null;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthday");
		String passport = request.getParameter("passport");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone_number");
		String driverLicence = request.getParameter("driver_licence");
		
		Date birthday = Date.valueOf(birthDate);
		Role role = new Role(1, "customer");
		
		customer = userService.registrationCustomer(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, role);
		
		httpSession = request.getSession();
		httpSession.setAttribute("user", customer);
		//request.setAttribute("", "");
		
		Cookie cookieLog = new Cookie("login", login);
		response.addCookie(cookieLog);
		Cookie cookiePass = new Cookie("password", password);
		response.addCookie(cookiePass);
		
		page = "/jsp/catalog.jsp";
		
		return page;
	}

}
