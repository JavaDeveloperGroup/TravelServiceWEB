package by.htp.travelserviceWEB.dao.auto.impl;

import java.util.List;

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
	public List<Entity> fetchListOfTheBodyTypes(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}