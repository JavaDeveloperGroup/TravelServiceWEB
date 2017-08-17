package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.hotel.Room;
import by.htp.travelserviceWEB.service.hotel.RoomService;
import by.htp.travelserviceWEB.service.hotel.impl.RoomServiceImpl;

public class FetchRoomAction implements CommandAction {
	
	private RoomService roomService;
	
	public FetchRoomAction() {
		roomService = RoomServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		Map<Integer, Entity> map = roomService.fillingListByTheRooms(new Room());
		request.setAttribute("room_map", map);
		
		return page;
	}

}