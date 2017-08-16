package by.htp.travelserviceWEB.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.filter.factory.CheckCommandList;
import by.htp.travelserviceWEB.util.Commands;

import static by.htp.travelserviceWEB.util.ConstantValue.*;

public final class CommandFilter extends AbstractFilter {

	private static final long serialVersionUID = 8120657689790657853L;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		final String MESSAGE = "No access!";
		
		String command = ((HttpServletRequest) servletRequest).getParameter(REQUEST_PARAM_ACTION);
		HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
		User user = (User) httpSession.getAttribute(SESSION_ATTRIBUTE_USER);
		if (checkUserAccess(user, command)) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			((HttpServletRequest) servletRequest).setAttribute(REQUEST_ATTRIBUTE_MSG, MESSAGE);
			((HttpServletResponse) servletResponse).sendRedirect(PAGE_HOME);
		}
	}

	private boolean checkUserAccess(User user, String command)
			throws IOException, ServletException {
		if (CheckCommandList.getInstance().fetchUserCommands(user)
				.getCommands().contains(Commands.valueOf(command.toUpperCase()))) {
			return true;
		} else {
			return false;
		}
	}
}