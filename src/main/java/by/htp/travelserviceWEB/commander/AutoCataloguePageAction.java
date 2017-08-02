package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoCataloguePageAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/auto_catalogue_page.jsp";
		
		return page;
	}

}
