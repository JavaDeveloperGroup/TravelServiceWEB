package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.extractionEntities;

import java.util.List;

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
	public List<Entity> fetchListOfTheColors(Entity entity) {
		return extractionEntities(entity);
	}
}