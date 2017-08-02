package by.htp.travelserviceWEB.dao.hotel.impl;

import by.htp.travelserviceWEB.dao.hotel.ApartmentDao;

public class ApartmentDaoImpl implements ApartmentDao {

	private ApartmentDaoImpl() {
	}

	private static class Singletone {
		private static final ApartmentDaoImpl INSTANCE = new ApartmentDaoImpl();
	}

	public static ApartmentDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}