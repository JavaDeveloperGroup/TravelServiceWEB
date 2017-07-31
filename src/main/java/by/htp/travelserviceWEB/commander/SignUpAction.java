package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;
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
		String login = request.getParameter("login");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String passwordEncrypt = EncryptionFdl.encrypt(request.getParameter("password"));
		String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter("password_repeat"));
		String passport = request.getParameter("passport");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone_number");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String driverLicence = request.getParameter("driver_licence");
		
		if (!Validator.registrationCustomer(login, passwordEncrypt, passwordRepeatEncrypt, name, surname, birthday, passport, email, phoneNumber)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			//create userTO
			userTO = new UserTO(login, passwordEncrypt);
			
			customer = new Customer(null, login, passwordEncrypt, name, surname, gender, birthday, passport, email,
					phoneNumber, driverLicence, 1);
			return getPage(request, response);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		Customer customer = null;
		
		httpSession = request.getSession();

		Admin admin = null;
		admin = serviceFactory.getUserService().authoriseAdmin(userTO);
		if (admin == null) {
			try {
				customer = serviceFactory.getUserService().registrationCustomer(this.customer);
			} catch (SQLException e) {
				return getPageOnErrorInputData(request);
			}
			httpSession.setAttribute("user", customer);
			// input data in Cookie
			inputCookie(request, response);
			log.info("Sign up " + customer.getLogin());
			page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
			httpSession.setAttribute("originalPage",  null);
		} else {
			page = getPageOnErrorInputData(request);
		}
		return page;
	}
	
	private String getPageOnErrorInputData(HttpServletRequest request){
		request.setAttribute("msg", "There is a user with such login.");
		page = "jsp/sign_up_page.jsp";
		log.info("Sign up is fail " + this.customer.getLogin());
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("log", this.customer.getLogin()));
		response.addCookie(new Cookie("passw", this.customer.getPassword()));
	}
}