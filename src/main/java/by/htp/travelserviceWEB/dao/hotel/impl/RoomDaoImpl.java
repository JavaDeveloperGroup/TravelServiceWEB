package by.htp.travelserviceWEB.dao.hotel.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.hotel.RoomDao;
import by.htp.travelserviceWEB.entity.Entity;

public class RoomDaoImpl implements RoomDao {

	private RoomDaoImpl() {
	}

	private static class Singletone {
		private static final RoomDaoImpl INSTANCE = new RoomDaoImpl();
	}

	public static RoomDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheRooms(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}