package by.htp.travelserviceWEB.dao.hotel.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.hotel.HotelDao;
import by.htp.travelserviceWEB.entity.Entity;

public class HotelDaoImpl implements HotelDao {

	private HotelDaoImpl() {
	}

	private static class Singletone {
		private static final HotelDaoImpl INSTANCE = new HotelDaoImpl();
	}

	public static HotelDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheHotels(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}