package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.Salon;
import by.htp.travelserviceWEB.service.auto.SalonService;
import by.htp.travelserviceWEB.service.auto.impl.SalonServiceImpl;

public class FetchSalonAction implements CommandAction {
	
	private SalonService salonService;
	
	public FetchSalonAction() {
		salonService = SalonServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		Map<Integer, Entity> map = salonService.fillingListByTheSolons(new Salon());
		request.setAttribute("salon_map", map);
		
		return page;
	}

}