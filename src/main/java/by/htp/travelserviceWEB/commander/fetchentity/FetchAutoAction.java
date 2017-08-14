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
import by.htp.travelserviceWEB.entity.auto.Auto;
import by.htp.travelserviceWEB.service.CityService;
import by.htp.travelserviceWEB.service.impl.CityServiceImpl;

public class FetchAutoAction implements CommandAction {
	
	private CityService cityService;
	
	public FetchAutoAction() {
		cityService = CityServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/auto_catalogue_page_sorting.jsp";
		
		List<Entity> list = cityService.fillingSelectPickUpCity(new Auto());
		Map<Integer, Auto> map = new HashMap<Integer, Auto>();
		for(Entity entity : list) {
			map.put(((Auto)entity).getAutoId(), (Auto) entity);
		}
		request.setAttribute("AUTO_MAP", map);
		
		return page;
	}

}
