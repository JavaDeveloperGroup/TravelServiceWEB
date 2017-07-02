package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.UserTO;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;
import by.htp.travelserviceWEB.util.Encryption;

public class LogInAction implements CommandAction {
	
private ServiceFactory serviceFactory; 
	
	public LogInAction() {
		serviceFactory = ServiceFactory.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		
		Customer customer = null;
		Admin admin = null;
		UserTO userDTO = null;
		
		HttpSession httpSession = request.getSession();
		
		String login = request.getParameter("login");
		String password = Encryption.md5Apache(request.getParameter("password"));
		
		userDTO = new UserTO(login, password);
		
		customer = serviceFactory.getUserService().authoriseCustomer(userDTO);
		
		if (customer == null) {
			admin = serviceFactory.getUserService().authoriseAdmin(userDTO);
			if (admin == null) {
				request.setAttribute("msg", "There is no user with such login.");
				page = "jsp/log_in_page.jsp";		
				return page;
			}
			
			httpSession.setAttribute("admin", admin);
			
			page = "jsp/admin_page.jsp";
		}
		else {
			
			httpSession.setAttribute("customer", customer);
			
			response.addCookie(new Cookie("log", login));
			response.addCookie(new Cookie("passw", request.getParameter("password")));
			
			page = "jsp/home_page.jsp";
		}

		return page;
	}
}