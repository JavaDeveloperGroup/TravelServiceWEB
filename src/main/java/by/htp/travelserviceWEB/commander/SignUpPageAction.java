package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpPageAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "jsp/signup_page.jsp";
		
		return page;
	}

}
