package by.htp.travelserviceWEB.service.impl;

import java.util.Map;

import by.htp.travelserviceWEB.dao.CityDao;
import by.htp.travelserviceWEB.dao.impl.CityDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.CityService;

public class CityServiceImpl implements CityService {
	
	private CityDao cityDao;

	private CityServiceImpl() {
		cityDao = CityDaoImpl.getInstance();
	}
	
	private static class Singletone {
		private static final CityServiceImpl INSTANCE = new CityServiceImpl();
	}

	public static CityServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fillingListByTheCities(Entity entity) {
		return cityDao.fetchListOfTheCities(entity);
	}
	
}
