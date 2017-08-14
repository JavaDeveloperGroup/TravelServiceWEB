package by.htp.travelserviceWEB.service.hotel.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.hotel.HotelDao;
import by.htp.travelserviceWEB.dao.hotel.impl.HotelDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.hotel.HotelService;

public class HotelServiceImpl implements HotelService {
	
	private HotelDao hotelDao;

	private HotelServiceImpl() {
		hotelDao = HotelDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final HotelServiceImpl INSTANCE = new HotelServiceImpl();
	}

	public static HotelServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheHotels(Entity entity) {
		return hotelDao.fetchListOfTheHotels(entity);
	}
}