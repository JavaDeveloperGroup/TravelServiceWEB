package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.Auto;
import by.htp.travelserviceWEB.service.auto.AutoService;
import by.htp.travelserviceWEB.service.auto.impl.AutoServiceImpl;

public class FetchAutoAction implements CommandAction {
	
	private AutoService autoService;
	
	public FetchAutoAction() {
		autoService = AutoServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";

		Map<Integer, Entity> map = autoService.fillingListByTheAutoes(new Auto());
		request.setAttribute("auto_map", map);
		
		return page;
	}

}
