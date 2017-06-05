package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.service.AdminService;
import by.htp.travelserviceWEB.service.AdminServiceImpl;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.CustomerServiceImpl;


public class LogInAction implements CommandAction {
	
	private CustomerService customerService; 
	private AdminService adminSevice;
	
	public LogInAction() {
		customerService = CustomerServiceImpl.getInstance();
		adminSevice = AdminServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		customerService.authoriseCustomer(login, password);

		return "/NewFile.jsp";
	}
	
}
