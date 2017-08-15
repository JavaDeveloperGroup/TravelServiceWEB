package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.BodyType;
import by.htp.travelserviceWEB.service.auto.BodyTypeService;
import by.htp.travelserviceWEB.service.auto.impl.BodyTypeServiceImpl;

public class FetchBodyTypeAction implements CommandAction {
	
	private BodyTypeService bodyTypeService;
	
	public FetchBodyTypeAction() {
		bodyTypeService = BodyTypeServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		Map<Integer, Entity> map = bodyTypeService.fillingListByTheBodyTypes(new BodyType());
		request.setAttribute("bodyType_map", map);
		
		return page;
	}

}