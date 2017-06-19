package by.htp.travelserviceWEB.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.commander.CommandManager;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
		String command = httpRequest.getParameter("command");

		/*if ("sign_up".equals(command) || "log_in".equals(command)) {
			if (httpRequest.getSession().getId().equals(httpRequest.getCookies()[num].getValue()) && isId) {
				RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/jsp/catalog_hotel_page.jsp");
				requestDispatcher.forward(req, resp);
				return;				
			} else {
				chain.doFilter(req, resp);
			}
		} else*/

			chain.doFilter(req, resp);
	}

	public void destroy() {

	}
}
