package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.List;

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
	public List<Entity> fetchListOfTheBrands(Entity entity) {
		return extractionEntities(entity);
	}
}