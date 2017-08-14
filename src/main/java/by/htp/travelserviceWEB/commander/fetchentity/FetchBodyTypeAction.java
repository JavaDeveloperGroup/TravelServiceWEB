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
import by.htp.travelserviceWEB.entity.auto.BodyType;
import by.htp.travelserviceWEB.service.CityService;
import by.htp.travelserviceWEB.service.impl.CityServiceImpl;

public class FetchBodyTypeAction implements CommandAction {
	
	private CityService cityService;
	
	public FetchBodyTypeAction() {
		cityService = CityServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/auto_catalogue_page.jsp";
		
		List<Entity> list = cityService.fillingSelectPickUpCity(new BodyType());
		Map<Integer, BodyType> map = new HashMap<Integer, BodyType>();
		for(Entity entity : list) {
			map.put(((BodyType)entity).getBodyTypeId(), (BodyType) entity);
		}
		request.setAttribute("CITY_MAP", map);
		
		return page;
	}

}
