package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.fetchentity.FetchCityAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchSalonAction;

public class AutoCataloguePageAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page = "jsp/auto_catalogue_page.jsp";
		
		new FetchCityAction().execute(request, response);
		
		new FetchSalonAction().execute(request, response);
		
		return page;
	}

}
