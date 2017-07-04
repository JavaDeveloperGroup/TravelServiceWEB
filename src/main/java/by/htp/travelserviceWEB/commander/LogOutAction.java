package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutAction implements CommandAction {
	
	public LogOutAction() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "index.jsp";

		request.getSession(false);
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		return page;
	}
}
