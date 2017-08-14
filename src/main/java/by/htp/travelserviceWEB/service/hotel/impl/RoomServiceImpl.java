package by.htp.travelserviceWEB.service.hotel.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.hotel.RoomDao;
import by.htp.travelserviceWEB.dao.hotel.impl.RoomDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.hotel.RoomService;

public class RoomServiceImpl implements RoomService {
	
	private RoomDao roomDao;
	{
		roomDao = RoomDaoImpl.getInstance();
	}

	private RoomServiceImpl() {
	}

	private static class Singletone {
		private static final RoomServiceImpl INSTANCE = new RoomServiceImpl();
	}

	public static RoomServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingSelectPickUpRoom(Entity entity) {
		return roomDao.fetchRoomName(entity);
	}
}