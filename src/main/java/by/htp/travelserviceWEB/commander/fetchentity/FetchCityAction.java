package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.City;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.CityService;
import by.htp.travelserviceWEB.service.impl.CityServiceImpl;

public class FetchCityAction implements CommandAction {
	
	private CityService cityService;
	
	public FetchCityAction() {
		cityService = CityServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		Map<Integer, Entity> map = cityService.fillingListByTheCities(new City());
		request.setAttribute("city_map", map);
		
		return page;
	}

}
