package by.htp.travelserviceWEB.dao.auto.impl;

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
		// TODO Auto-generated method stub
		return null;
	}
}