package by.htp.travelserviceWEB.dao.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.CityDao;
import by.htp.travelserviceWEB.entity.Entity;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class CityDaoImpl implements CityDao {

	private CityDaoImpl() {
	}

	private static class Singletone {
		private static final CityDaoImpl INSTANCE = new CityDaoImpl();
	}

	public static CityDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchListOfTheCities(Entity entity) {
		return extractionEntities(entity);
	}
}
