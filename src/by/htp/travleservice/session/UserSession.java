package by.htp.travleservice.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession {
	
	private HttpSession session;

	public UserSession() {
		super();
	}

	public UserSession(HttpServletRequest request) {
		super();
		session = request.getSession(true);
	}

	public HttpSession getSession() {
		return session;
	}
	
	//request.getSession().invalidate();//close session
}
