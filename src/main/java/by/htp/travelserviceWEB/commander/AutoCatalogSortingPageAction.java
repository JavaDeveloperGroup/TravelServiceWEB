package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.fetchentity.FetchAutoAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchBodyTypeAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchBrandAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchCityAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchColorAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchHotelAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchRoomAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchSalonAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.RentAuto;
import by.htp.travelserviceWEB.service.auto.RentAutoService;
import by.htp.travelserviceWEB.service.auto.impl.RentAutoServiceImpl;

public class AutoCatalogSortingPageAction implements CommandAction{

	private RentAutoService rentAutoServiceImpl;
	
	public AutoCatalogSortingPageAction() {
		rentAutoServiceImpl = RentAutoServiceImpl.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = "jsp/auto_catalogue_sorting_page.jsp";

		new FetchAutoAction().execute(request, response);
		new FetchBodyTypeAction().execute(request, response);
		new FetchBrandAction().execute(request, response);
		new FetchCityAction().execute(request, response);
		new FetchColorAction().execute(request, response);
		new FetchSalonAction().execute(request, response);
		
		List<Entity> list = rentAutoServiceImpl.fillingListByTheRentAutoes(new RentAuto());

		request.setAttribute("rentAuto_list", list);

		return page;
	}

}
