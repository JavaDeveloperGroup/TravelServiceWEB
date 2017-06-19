package by.htp.travelserviceWEB.commander;

import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.dto.CustomerDTOImpl;
import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.CustomerImpl;
import by.htp.travelserviceWEB.entity.Role;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;

public class SignUpAction implements CommandAction {

	private UserService userService;
	
	private String page;
	
	private CustomerImpl customer;
	private UserDTO userDTO;
	private Customer customerDTO;
	
	private String login;
	private String password;
	private String name;
	private String surname;
	private String gender;
	private Date birthday;
	private String passport;
	private String email;
	private String phoneNumber;
	private String driverLicense;
	private Role role;

	public SignUpAction() {
		userService = UserServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		login = request.getParameter("login");
		password = request.getParameter("password");
		String repPassword = request.getParameter("repeat_password");
		
		if(!password.equals(repPassword)) {
			page = "jsp/signup_page.jsp";
			return page;
		}
		else {
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			gender = request.getParameter("gender");
			String birthDate = request.getParameter("birthday");
			passport = request.getParameter("passport");
			email = request.getParameter("email");
			phoneNumber = request.getParameter("phone_number");
			driverLicense = request.getParameter("driver_license");

			birthday = Date.valueOf(birthDate);
			role = new Role(1, "customer");

			return getPage(request, response);
		}		
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		
		userDTO = new UserDTO(login, password);
		
		customer = userService.authoriseCustomer(userDTO);	
		
		if (customer == null) {
			Admin admin = null;
			admin = userService.authoriseAdmin(userDTO);
			if (admin == null) {
				customerDTO = new CustomerDTOImpl(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicense, role);
				
				customer = userService.registrationCustomer(customerDTO);

				System.out.println(request.getSession().getId());
				
				request.getSession().setAttribute("user", customer);
				// request.setAttribute("", "");

				Cookie cookieLog = new Cookie("login", login);
				response.addCookie(cookieLog);
				Cookie cookiePass = new Cookie("password", request.getParameter("password"));
				response.addCookie(cookiePass);

				Cookie[] cookies = request.getCookies();

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
