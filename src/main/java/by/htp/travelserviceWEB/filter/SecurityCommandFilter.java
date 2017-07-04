package by.htp.travelserviceWEB.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.filter.InitSecurityCommand.Singleton;

public class SecurityCommandFilter implements Filter {

	private String page;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServetRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		String command = httpServetRequest.getParameter("command");
		HttpSession httpSession = httpServetRequest.getSession();
		Customer customer = (Customer) httpSession.getAttribute("customer");
		Admin admin = (Admin) httpSession.getAttribute("admin");

		if (null == customer && null == admin) {
			if (InitSecurityCommand.getInstance().initGuestCommand(command)) {
				chain.doFilter(servletRequest, servletResponse);
			} else {
				httpServletResponse.sendRedirect("jsp/home_page.jsp");
			}
		} else if (null != customer && InitSecurityCommand.getInstance().initCustomerCommand(command)) {
			chain.doFilter(servletRequest, servletResponse);
		} else if (null != admin && InitSecurityCommand.getInstance().initAdminCommand(command)) {
			chain.doFilter(servletRequest, servletResponse);
		} else 
			httpServletResponse.sendRedirect("jsp/home_page.jsp");
	}

	@Override
	public void destroy() {
		page = null;
	}
}

final class InitSecurityCommand {
	
	private static final Set<String> customerListCommand = new HashSet<>();
	private static final Set<String> guestListCommand = new HashSet<>();
	private static final Set<String> adminListCommand = new HashSet<>();
	
	private InitSecurityCommand() {
		
	}
	
	static class Singleton {
		private static final InitSecurityCommand INSTANCE = new InitSecurityCommand();
	}
	
	public static InitSecurityCommand getInstance() {
		return Singleton.INSTANCE;
	}
	
	static {
		customerListCommand.add("hotel_catalog_page");
		customerListCommand.add("auto_catalog_page");
		customerListCommand.add("tour_catalog_page");
		customerListCommand.add("hotel_make_order");
		customerListCommand.add("auto_make_order");
		customerListCommand.add("tour_make_order");
		customerListCommand.add("log_out");
	}
	static {
		guestListCommand.add("catalog_hotel_page");
		guestListCommand.add("catalog_auto_page");
		guestListCommand.add("catalog_tour_page");
		guestListCommand.add("log_in_page");
		guestListCommand.add("sign_up_page");
		guestListCommand.add("log_in");
		guestListCommand.add("sign_up");
	}
	static {
		adminListCommand.add("catalog_hotel_page");
		adminListCommand.add("catalog_auto_page");
		adminListCommand.add("catalog_tour_page");
		adminListCommand.add("admin_page");
		adminListCommand.add("log_out");
	}
	
	boolean initCustomerCommand(String command) {
		return customerListCommand.contains(command);
	}
	boolean initAdminCommand(String command) {
		return adminListCommand.contains(command);
	}
	boolean initGuestCommand(String command) {
		return guestListCommand.contains(command);		
	}
	
}