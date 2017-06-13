package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "index.jsp";

		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		
		request.setAttribute("login", cookies[1].getValue());
		request.setAttribute("password", cookies[2].getValue());
		
		return page;
	}

}
