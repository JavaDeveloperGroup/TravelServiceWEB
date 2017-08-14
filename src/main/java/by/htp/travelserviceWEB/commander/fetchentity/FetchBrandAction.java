package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.City;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.CityService;
import by.htp.travelserviceWEB.service.impl.CityServiceImpl;

public class FetchBrandAction implements CommandAction {
	
	private CityService cityService;
	
	public FetchBrandAction() {
		cityService = CityServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/auto_catalogue_page.jsp";
		
		List<Entity> list = cityService.fillingSelectPickUpCity(new City());
		Map<Integer, City> map = new HashMap<Integer, City>();
		for(Entity city : list) {
			map.put(((City)city).getCityId(), (City) city);
		}
		request.setAttribute("CITY_MAP", map);
		
		return page;
	}

}
