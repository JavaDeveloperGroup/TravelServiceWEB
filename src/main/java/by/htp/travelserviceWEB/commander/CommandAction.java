package by.htp.travelserviceWEB.commander;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	
	//String execute(HttpServletRequest request);
	//String execute(HttpServletResponse response);
	String execute(HttpServletRequest request, HttpServletResponse response);
	
}
