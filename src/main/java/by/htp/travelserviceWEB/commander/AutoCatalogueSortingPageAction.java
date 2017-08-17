package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.fetchentity.FetchAutoAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchCityAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchSalonAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.RentAuto;
import by.htp.travelserviceWEB.service.auto.RentAutoService;
import by.htp.travelserviceWEB.service.auto.impl.RentAutoServiceImpl;

public class AutoCatalogueSortingPageAction implements CommandAction{

	private RentAutoService rentAutoServiceImpl;
	
	public AutoCatalogueSortingPageAction() {
		rentAutoServiceImpl = RentAutoServiceImpl.getInstance();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = "jsp/auto_catalogue_sorting_page.jsp";

		new FetchAutoAction().execute(request, response);
		new FetchCityAction().execute(request, response);
		new FetchSalonAction().execute(request, response);
		
		List<Entity> list = rentAutoServiceImpl.fillingListByTheRentAutoes(new RentAuto());
		request.setAttribute("rentAuto_list", list);

		return page;
	}

}
