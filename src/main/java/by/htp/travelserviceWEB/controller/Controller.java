package by.htp.travelserviceWEB.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.commander.CommandManager;
import by.htp.travelserviceWEB.connector.ConnectionPoolImpl;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 6613316973192999815L;

	public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String page;
		if (command != null) {
			CommandAction commandAction = CommandManager.getInstance().init().get(command);
			page = commandAction.execute(request, response);
			
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}		
	}

	@Override
	public void destroy() {
		super.destroy();
		ConnectionPoolImpl.getInstance().close();
	}
	
	
}
