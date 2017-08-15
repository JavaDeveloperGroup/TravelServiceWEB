package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.BrandDao;
import by.htp.travelserviceWEB.entity.Entity;

public class BrandDaoImpl implements BrandDao {

	private BrandDaoImpl() {
	}

	private static class Singletone {
		private static final BrandDaoImpl INSTANCE = new BrandDaoImpl();
	}

	public static BrandDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fetchListOfTheBrands(Entity entity) {
		return extractionEntitiesInMap(entity);
	}
}