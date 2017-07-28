package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.dto.AdminTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;

public class LogInAction implements CommandAction {
	
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private CustomerTO customerTO;
	
	private CustomerService customerService;
	{
		customerService = CustomerServiceImpl.getInstance();
	}
	
	public LogInAction() {}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page;		
		AdminTO adminTO = null;
		CustomerTOLP userDTO;
		
		HttpSession httpSession = request.getSession();
		
		String login = request.getParameter("login");
		String passwordEncrypt = EncryptionFdl.encrypt(request.getParameter("password"));
		userDTO = new CustomerTOLP(login, passwordEncrypt);
	
		customerTO = customerService.authoriseCustomer(customerTO, userDTO);
		System.out.println(customerTO.getName());
		
		if (customerTO == null) {
			adminTO = customerService.authoriseAdmin(adminTO, userDTO);
			if (adminTO == null) {
				request.setAttribute("msg", "There is no user with such login.");
				page = "jsp/log_in_page.jsp";		
				return page;
			}
			httpSession.setAttribute("user", adminTO);
			log.info("Log in admin " + adminTO.getLogin());
			page = "jsp/admin_page.jsp";
		}
		else {
			httpSession.setAttribute("user", customerTO);
			inputCookie(request, response);
			log.info("Log in customer " + customerTO.getLogin());
			page = "jsp/home_page.jsp";
		}
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customerTO.getLogin()));
		response.addCookie(new Cookie("password", this.customerTO.getPassword()));
	}
}