package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;

public class LogInPageAction implements CommandAction{

	public LogInPageAction() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "jsp/log_in_page.jsp";
		HttpSession httpSesion = request.getSession();
		httpSesion.setAttribute("originalPage", ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request));
		
		return page;
	}

}
