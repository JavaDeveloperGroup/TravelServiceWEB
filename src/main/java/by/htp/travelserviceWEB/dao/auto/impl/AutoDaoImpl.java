package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.AutoDao;
import by.htp.travelserviceWEB.entity.Entity;

public class AutoDaoImpl implements AutoDao {

	private AutoDaoImpl() {
	}

	private static class Singletone {
		private static final AutoDaoImpl INSTANCE = new AutoDaoImpl();
	}

	public static AutoDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheAutoes(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}