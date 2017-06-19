package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.dto.UserDTO;
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.CustomerImpl;
import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.UserServiceImpl;
import by.htp.travelserviceWEB.util.Encryption;

public class LogInAction implements CommandAction {
	
	private UserService userService; 
	
	public LogInAction() {
		userService = UserServiceImpl.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		
		CustomerImpl customer = null;
		Admin admin = null;
		UserDTO userDTO = null;
		
		HttpSession httpSession = request.getSession();
		
		String login = request.getParameter("login");
		String password = Encryption.md5Apache(request.getParameter("password"));
		
		userDTO = new UserDTO(login, password);
		
		customer = userService.authoriseCustomer(userDTO);
		
		if (customer == null) {
			admin = userService.authoriseAdmin(userDTO);
			if (admin == null) {
				request.setAttribute("msg", "There is no user with such login.");
				page = "jsp/login_page.jsp";		
				return page;
			}
			
			httpSession.setAttribute("user", admin);
			//request.setAttribute("", "");
			
			page = "jsp/admin_page.jsp";
		}
		else {
			
			httpSession.setAttribute("user", customer);
			//request.setAttribute("", "");
			
			response.addCookie(new Cookie("log", login));
			response.addCookie(new Cookie("passw", request.getParameter("password")));
			
			page = "jsp/catalog_hotel_page.jsp";
		}

		return page;
	}
	
}
