package by.htp.travelserviceWEB.dao.hotel.impl;

import by.htp.travelserviceWEB.dao.hotel.HotelDao;

public class HotelDaoImpl implements HotelDao {

	private HotelDaoImpl() {
	}

	private static class Singletone {
		private static final HotelDaoImpl INSTANCE = new HotelDaoImpl();
	}

	public static HotelDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}