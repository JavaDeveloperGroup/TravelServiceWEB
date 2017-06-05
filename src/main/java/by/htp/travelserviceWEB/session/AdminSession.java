package by.htp.travelserviceWEB.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminSession {
	
	private HttpSession session;

	public AdminSession() {
		super();
	}

	public AdminSession(HttpServletRequest request) {
		super();
		session = request.getSession(true);
	}

	public HttpSession getSession() {
		return session;
	}	
}
