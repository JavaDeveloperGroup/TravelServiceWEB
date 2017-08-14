package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String page = "jsp/auto_catalogue_page_sorting.jsp";

		List<Entity> list = rentAutoServiceImpl.fillingListByTheRentAutoes(new RentAuto());

		request.setAttribute("rentAuto_list", list);

		return page;
	}

}
