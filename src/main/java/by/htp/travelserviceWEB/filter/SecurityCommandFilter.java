package by.htp.travelserviceWEB.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityCommandFilter implements Filter {

	private String command;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		FilterChain filterChain = chain;

		this.command = ((HttpServletRequest) servletRequest).getParameter("command");
		HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
		Object user = httpSession.getAttribute("user");
		checkUserSeccus(user, servletResponse);
		filterChain.doFilter(servletRequest, servletResponse);
	}
	
	private void checkUserSeccus(Object user, ServletResponse servletResponse) throws IOException, ServletException {
		if (null == user) {
			if (InitSecurityCommand.getInstance().checkGuestCommand(command)) {
			} else {
				((HttpServletResponse)servletResponse).sendRedirect("jsp/home_page.jsp");
			}
		} else if ("Customer".equals(user.getClass().getSimpleName().subSequence(0, 8)) && InitSecurityCommand.getInstance().checkCustomerCommand(command)) {
		} else if ("Admin".equals(user.getClass().getSimpleName().substring(0, 5)) && InitSecurityCommand.getInstance().checkAdminCommand(command)) {
		} else 
			((HttpServletResponse)servletResponse).sendRedirect("jsp/home_page.jsp");
	}

	@Override
	public void destroy() {	}
}

final class InitSecurityCommand {
	
	private static final Set<String> customerListCommand = Collections.synchronizedSet(new HashSet<>());
	private static final Set<String> guestListCommand = Collections.synchronizedSet(new HashSet<>());
	private static final Set<String> adminListCommand = Collections.synchronizedSet(new HashSet<>());
	
	private InitSecurityCommand() {
		
	}
	
	static class Singleton {
		private static final InitSecurityCommand INSTANCE = new InitSecurityCommand();
	}
	
	public static InitSecurityCommand getInstance() {
		return Singleton.INSTANCE;
	}
	
	static {
		customerListCommand.add("hotel_catalogue_page");
		customerListCommand.add("auto_catalogue_sorting_page");
		customerListCommand.add("auto_sort_salon_page");
		customerListCommand.add("tour_catalogue_page");
		customerListCommand.add("hotel_make_order");
		customerListCommand.add("auto_make_order");
		customerListCommand.add("tour_make_order");
		customerListCommand.add("log_out");
		customerListCommand.add("update_account_page");
		customerListCommand.add("update_account");
	}
	static {
		guestListCommand.add("hotel_catalogue_page");
		guestListCommand.add("auto_catalogue_sorting_page");
		guestListCommand.add("auto_sort_salon_page");
		guestListCommand.add("tour_catalogue_page");
		guestListCommand.add("log_in_page");
		guestListCommand.add("sign_up_page");
		guestListCommand.add("log_in");
		guestListCommand.add("sign_up");
	}
	static {
		adminListCommand.add("hotel_catalogue_page");
		adminListCommand.add("auto_catalogue_sorting_page");
		adminListCommand.add("auto_sort_salon_page");
		adminListCommand.add("tour_catalogue_page");
		adminListCommand.add("admin_page");
		adminListCommand.add("log_out");
	}
	
	boolean checkCustomerCommand(String command) {
		return customerListCommand.contains(command);
	}
	boolean checkAdminCommand(String command) {
		return adminListCommand.contains(command);
	}
	boolean checkGuestCommand(String command) {
		return guestListCommand.contains(command);		
	}
	
}