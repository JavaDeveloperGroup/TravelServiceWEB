package by.htp.travelserviceWEB.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandChooser;

public class MyFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
		String comm = httpRequest.getParameter("command");
		
		/*if ("log_in".equals(comm)) {
			String page = CommandChooser.chooserAction("log_in").execute(httpRequest, httpResponse);
			RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher(page);
			requestDispatcher.forward(req, resp);
			return;
		} else*/ {
			chain.doFilter(req, resp);
		}

		/*RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(req, resp);*/

	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter init");
	}
}
