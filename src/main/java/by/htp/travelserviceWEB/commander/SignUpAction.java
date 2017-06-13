package by.htp.travelserviceWEB.commander;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.dto.CustomerDTO;
import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;

public class SignUpAction implements CommandAction {

	private UserService userService;

	public SignUpAction() {
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

		UserDTO userDTO = new UserDTO(login, password);
		
		customer = userService.authoriseCustomer(userDTO);

		if (customer == null) {
			Admin admin = null;
			admin = userService.authoriseAdmin(userDTO);
			if (admin == null) {
				CustomerDTO customerDTO = new CustomerDTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, role);
				
				//ValidationDTO
				
				customer = userService.registrationCustomer(customerDTO);

				httpSession = request.getSession();
				httpSession.setAttribute("user", customer);
				// request.setAttribute("", "");

				Cookie cookieLog = new Cookie("login", login);
				response.addCookie(cookieLog);
				Cookie cookiePass = new Cookie("password", password);
				response.addCookie(cookiePass);

				//Cookie[] cookies = request.getCookies();

				page = "/jsp/catalog_page.jsp";
				
			}
			else {
				request.setAttribute("msg", "There is a user with such login.");
				page = "signup_page.jsp";
			}
		} else {
			request.setAttribute("msg", "There is a user with such login.");
			page = "signup_page.jsp";
		}	

		return page;
	}
	
	
	

}
