package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.extractionEntities;

import java.util.List;

import by.htp.travelserviceWEB.dao.auto.SalonDao;
import by.htp.travelserviceWEB.entity.Entity;

public class SalonDaoImpl implements SalonDao {

	private SalonDaoImpl() {
	}

	private static class Singletone {
		private static final SalonDaoImpl INSTANCE = new SalonDaoImpl();
	}

	public static SalonDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchListOfTheSalons(Entity entity) {
		return extractionEntities(entity);
	}
}