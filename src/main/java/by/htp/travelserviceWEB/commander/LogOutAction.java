package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutAction implements CommandAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "index.jsp";

		request.getSession(false);
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		saveAuthoriseData(request);
		return page;
	}
	
	private void saveAuthoriseData(HttpServletRequest request) {
		Cookie[] cookie = request.getCookies();

		for (int i = 0, k = cookie.length; i < k; i++) {
			if ("log".equals(cookie[i].getName())) {
				request.setAttribute("login", cookie[i].getValue());
			}
			else if ("passw".equals(cookie[i].getName())) {
				request.setAttribute("password", cookie[i].getValue());
			}
		}
	}

}
