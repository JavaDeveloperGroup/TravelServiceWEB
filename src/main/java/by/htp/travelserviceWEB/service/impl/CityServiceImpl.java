package by.htp.travelserviceWEB.service.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.CityDao;
import by.htp.travelserviceWEB.dao.impl.CityDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.CityService;

public class CityServiceImpl implements CityService {
	
	private CityDao cityDao;
	{
		cityDao = CityDaoImpl.getInstance();
	}

	private CityServiceImpl() {}
	
	private static class Singletone {
		private static final CityServiceImpl INSTANCE = new CityServiceImpl();
	}

	public static CityServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
	
	@Override
	public List<Entity> fillingSelectPickUpCity(Entity entity) {
		return cityDao.fetchCityName(entity);
	}
	
}
