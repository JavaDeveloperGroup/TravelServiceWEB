package by.htp.travelserviceWEB.dao.hotel.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.List;

import by.htp.travelserviceWEB.dao.hotel.ApartmentDao;
import by.htp.travelserviceWEB.entity.Entity;

public class ApartmentDaoImpl implements ApartmentDao {

	private ApartmentDaoImpl() {}

	private static class Singletone {
		private static final ApartmentDaoImpl INSTANCE = new ApartmentDaoImpl();
	}

	public static ApartmentDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchListOfTheApartments(Entity entity) {
		return extractionEntities(entity);
	}
	
	
}