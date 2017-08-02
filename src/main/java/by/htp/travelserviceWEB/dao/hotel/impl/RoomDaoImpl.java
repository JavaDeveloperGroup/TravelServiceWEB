package by.htp.travelserviceWEB.dao.hotel.impl;

import by.htp.travelserviceWEB.dao.hotel.RoomDao;

public class RoomDaoImpl implements RoomDao {

	private RoomDaoImpl() {
	}

	private static class Singletone {
		private static final RoomDaoImpl INSTANCE = new RoomDaoImpl();
	}

	public static RoomDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}