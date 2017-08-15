package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.ColorDao;
import by.htp.travelserviceWEB.entity.Entity;

public class ColorDaoImpl implements ColorDao {

	private ColorDaoImpl() {
	}

	private static class Singletone {
		private static final ColorDaoImpl INSTANCE = new ColorDaoImpl();
	}

	public static ColorDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheColors(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}