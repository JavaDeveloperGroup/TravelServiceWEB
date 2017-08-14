package by.htp.travelserviceWEB.service.auto.impl;

import java.util.List;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.BrandService;

public class BrandServiceImpl implements BrandService {

	private BrandServiceImpl() {
	}

	private static class Singletone {
		private static final BrandServiceImpl INSTANCE = new BrandServiceImpl();
	}

	public static BrandServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheBrands(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}