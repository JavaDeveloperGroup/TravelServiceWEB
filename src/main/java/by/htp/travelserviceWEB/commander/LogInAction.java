package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;

import static by.htp.travelserviceWEB.util.ConstantValue.*;

public class LogInAction implements CommandAction {
	
	private UserService userService; 
	
	public LogInAction() {
		userService = UserServiceImpl.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		
		Customer customer = null;
		Admin admin = null;
		
		HttpSession httpSession;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		customer = userService.authoriseCustomer(login, password);
		
		if (customer == null) {
			admin = userService.authoriseAdmin(login, password);
			if (admin == null) {
				page = "/jsp/index.jsp";				
			}
			httpSession = request.getSession();
			httpSession.setAttribute("user", admin);
			request.setAttribute("", "");
			
			Cookie cookieLog = new Cookie("login", login);
			response.addCookie(cookieLog);
			Cookie cookiePass = new Cookie("password", password);
			response.addCookie(cookiePass);
			
			//Cookie[] cookies = request.getCookies();
			
			page = "/jsp/catalog.jsp";
		}
		else {
			httpSession = request.getSession();
			httpSession.setAttribute("user", customer);
			request.setAttribute("", "");
			
			Cookie cookieLog = new Cookie("login", login);
			response.addCookie(cookieLog);
			Cookie cookiePass = new Cookie("password", password);
			response.addCookie(cookiePass);
			
			//Cookie[] cookies = request.getCookies();
			
			page = "/jsp/catalog.jsp";
		}

		return page;
	}
	
}
