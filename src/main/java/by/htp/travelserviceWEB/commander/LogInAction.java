package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;

public final class LogInAction implements CommandAction {
	
	private static final Logger log = Logger.getLogger(LogInAction.class);
	private Customer customer;
	
	private CustomerService customerService;
	
	public LogInAction() {
		customerService = CustomerServiceImpl.getInstance();
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page;		
		AdminTOWP adminTOWP = null;
		CustomerTOLP customerTOLP;
		
		HttpSession httpSession = request.getSession();
		
		String login = request.getParameter("login");
		String passwordEncrypt = EncryptionFdl.encrypt(request.getParameter("password"));
		customerTOLP = new CustomerTOLP(login, passwordEncrypt);
	
		customer = customerService.authoriseCustomer(customerTOLP);
		
		if (customer == null) {
			adminTOWP = customerService.authoriseAdmin(customerTOLP);
			if (adminTOWP == null) {
				request.setAttribute("msg", "There is no user with such login.");
				page = "jsp/log_in_page.jsp";		
				return page;
			}
			httpSession.setAttribute("user", adminTOWP);
			log.info("Log in admin " + adminTOWP.getLogin());
			page = "jsp/admin_page.jsp";
		}
		else {
			httpSession.setAttribute("user", customer);
			inputCookie(request, response);
			log.info("Log in customer " + customer.getLogin());
			page = "jsp/home_page.jsp";
		}
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customer.getLogin()));
		response.addCookie(new Cookie("password", this.customer.getPassword()));
	}
}