package by.htp.travelserviceWEB.commander;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.fetchentity.FetchCityAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchHotelAction;
import by.htp.travelserviceWEB.commander.fetchentity.FetchRoomAction;
import by.htp.travelserviceWEB.entity.hotel.Apartment;
import by.htp.travelserviceWEB.service.hotel.ApartmentService;
import by.htp.travelserviceWEB.service.hotel.impl.ApartmentServiceImpl;
import by.htp.travelserviceWEB.entity.Entity;

public class HotelCataloguePageAction implements CommandAction {
	
	private ApartmentService apartmentService;
	
	public HotelCataloguePageAction() {
		apartmentService = ApartmentServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page = "jsp/hotel_catalogue_page.jsp";
		
		new FetchCityAction().execute(request, response);
		
		new FetchHotelAction().execute(request, response);
		
		new FetchRoomAction().execute(request, response);
		
		List<Entity> list = apartmentService.fillingListByTheApartments(new Apartment());
		//List l = Collections.sort(list, (Entity a, Entity b) -> b.compareTo(a));
		request.setAttribute("APARTMENT_LIST", list);
		
		return page;
	}

}
