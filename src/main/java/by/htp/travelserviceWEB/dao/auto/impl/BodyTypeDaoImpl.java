package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.BodyTypeDao;
import by.htp.travelserviceWEB.entity.Entity;

public class BodyTypeDaoImpl implements BodyTypeDao {

	private BodyTypeDaoImpl() {
	}

	private static class Singletone {
		private static final BodyTypeDaoImpl INSTANCE = new BodyTypeDaoImpl();
	}

	public static BodyTypeDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheBodyTypes(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}