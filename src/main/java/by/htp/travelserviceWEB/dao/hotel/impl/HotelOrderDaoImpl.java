package by.htp.travelserviceWEB.dao.hotel.impl;

import by.htp.travelserviceWEB.dao.hotel.HotelOrderDao;

public class HotelOrderDaoImpl implements HotelOrderDao {

private HotelOrderDaoImpl() {}

private static class Singletone{
private static final HotelOrderDaoImpl INSTANCE = new HotelOrderDaoImpl();
	}

public static HotelOrderDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}