package by.htp.travelserviceWEB.commander;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.entity.Customer;
import by.htp.travelserviceWEB.entity.User;

interface InputCookie {
	
	default void createCookie(HttpServletRequest request, HttpServletResponse response, User user) {
		
		response.addCookie(new Cookie("log", user.getLogin()));
		response.addCookie(new Cookie("passw", ((Customer)user).getPassword()));
	}

}
