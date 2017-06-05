package by.htp.travelserviceWEB.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ConstantValue {
	
	private HttpSession session;

	public ConstantValue() {
		super();
	}

	public ConstantValue(HttpServletRequest request) {
		super();
		session = request.getSession(true);
	}

	public HttpSession getSession() {
		return session;
	}
}
