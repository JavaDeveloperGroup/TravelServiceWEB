package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.util.ReturnToTheOriginalPage;

public class UpdateAccountPageAction implements CommandAction {
	
	public UpdateAccountPageAction() {}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/update_account_page.jsp";
		
		HttpSession httpSesion = request.getSession();
		httpSesion.setAttribute("originalPage", ReturnToTheOriginalPage.getOriginalPage(request.getHeader("referer"), request));
		
		return page;
	}

}
