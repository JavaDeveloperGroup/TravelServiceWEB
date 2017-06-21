package by.htp.travelserviceWEB.filter;

import java.io.IOException;
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

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public class SecurityUserFilter implements Filter {
	
	private String page;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServetRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		
		String command = httpServetRequest.getParameter("command");

		HttpSession httpSession = httpServetRequest.getSession();

		Customer customer = (Customer) httpSession.getAttribute("customer");
		Admin admin = (Admin) httpSession.getAttribute("admin");

		if (null != customer && initCustomerCommand(command)) {
			chain.doFilter(servletRequest, servletResponse);
		} else if (null != admin && initAdminCommand(command)) {
			chain.doFilter(servletRequest, servletResponse);
		} else
			httpServletResponse.sendRedirect("/index.jsp");
	}

	@Override
	public void destroy() {
		page = null;
	}
	
	private boolean initCustomerCommand(String command) {
		Set<String> listCommand = new HashSet<String>();
		listCommand.add("make_order");
		listCommand.add("log_out");
		return listCommand.contains(command);
	}
	private boolean initAdminCommand(String command) {
		Set<String> listCommand = new HashSet<String>();
		listCommand.add("rem_order");
		listCommand.add("log_out");
		return listCommand.contains(command);
	}

}
