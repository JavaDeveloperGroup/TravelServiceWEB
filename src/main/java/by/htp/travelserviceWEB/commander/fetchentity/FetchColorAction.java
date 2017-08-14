package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.Color;
import by.htp.travelserviceWEB.service.auto.ColorService;
import by.htp.travelserviceWEB.service.auto.impl.ColorServiceImpl;

public class FetchColorAction implements CommandAction {
	
	private ColorService colorService;
	
	public FetchColorAction() {
		colorService = ColorServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/auto_catalogue_page_sorting.jsp";
		
		List<Entity> list = colorService.fillingListByTheColors(new Color());
		request.setAttribute("color_list", list);
		
		return page;
	}

}
