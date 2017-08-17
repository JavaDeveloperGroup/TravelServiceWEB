package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class LogOutAction implements CommandAction {
	
	private static final Logger log = Logger.getLogger(LogOutAction.class);
	
	public LogOutAction() {
		super();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "jsp/home_page.jsp";

		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		log.info("Log out " + getRoleName(user) + user.getLogin());

		request.getSession(false);
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		return page;
	}
}
