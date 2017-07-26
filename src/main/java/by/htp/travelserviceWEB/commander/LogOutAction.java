package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public class LogOutAction implements CommandAction {
	
	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	public LogOutAction() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "index.jsp";
		
		//produce session
		HttpSession httpSession = request.getSession();
		
		System.out.println(request.getHeader("referer"));
		Object user = httpSession.getAttribute("user");
		
		log.info("Log out " + ("Admin".equals(user.getClass().getSimpleName()) ? "admin " + ((Admin)user).getLogin() : "customer" + ((Customer)user).getLogin()));

		request.getSession(false);
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		return page;
	}
}
