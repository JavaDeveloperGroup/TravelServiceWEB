package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.hotel.Hotel;
import by.htp.travelserviceWEB.service.hotel.HotelService;
import by.htp.travelserviceWEB.service.hotel.impl.HotelServiceImpl;

public class FetchHotelAction implements CommandAction {
	
	private HotelService hotelService;
	
	public FetchHotelAction() {
		hotelService = HotelServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		List<Entity> list = hotelService.fillingListByTheHotels(new Hotel());
		Map<Integer, Hotel> map = new HashMap<Integer, Hotel>();
		for(Entity hotel : list) {
			map.put(((Hotel)hotel).getHotelId(), (Hotel) hotel);
		}
		request.setAttribute("HOTEL_MAP", map);
		
		return page;
	}

}