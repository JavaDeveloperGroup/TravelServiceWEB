package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;

public class LogInAction implements CommandAction {
	
	private ServiceFactory serviceFactory; 
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private Customer customer;
	
	public LogInAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page;		
		Admin admin = null;
		UserTO userDTO;
		
		//produce session
		HttpSession httpSession = request.getSession();
		
		//create userTO
		String login = request.getParameter("login");
		String passwordEncrypt = EncryptionFdl.encrypt(request.getParameter("password"));
		userDTO = new UserTO(login, passwordEncrypt);
	
		customer = serviceFactory.getUserService().authoriseCustomer(userDTO);
		
		if (customer == null) {
			admin = serviceFactory.getUserService().authoriseAdmin(userDTO);
			if (admin == null) {
				request.setAttribute("msg", "There is no user with such login.");
				page = "jsp/log_in_page.jsp";		
				return page;
			}
			httpSession.setAttribute("user", admin);
		}
		else {
			httpSession.setAttribute("user", customer);
			//input data in Cookie
			inputCookie(request, response);
		}
		
		page = ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request);
		httpSession.setAttribute("originalPage",  null);
		log.info("Log in " + (admin != null ? "admin " + admin.getLogin() : "customer " + customer.getLogin()));
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("log", this.customer.getLogin()));
		response.addCookie(new Cookie("passw", this.customer.getPassword()));
	}
}