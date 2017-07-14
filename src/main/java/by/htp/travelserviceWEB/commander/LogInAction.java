package by.htp.travelserviceWEB.commander;

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

public class LogInAction implements CommandAction {
	
	private ServiceFactory serviceFactory; 
	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	public LogInAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page;		
		Customer customer;
		Admin admin;
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
		
			page = "jsp/admin_page.jsp";
		}
		else {
			httpSession.setAttribute("user", customer);
			
			response.addCookie(new Cookie("log", login));
			response.addCookie(new Cookie("passw", passwordEncrypt));

			page = "jsp/home_page.jsp";
		}
		log.info("Log in " + ((Customer)httpSession.getAttribute("user")).getLogin());
		return page;
	}
}