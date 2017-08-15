package by.htp.travelserviceWEB.service.auto.impl;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.AutoDao;
import by.htp.travelserviceWEB.dao.auto.impl.AutoDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.AutoService;

public class AutoServiceImpl implements AutoService {

	private AutoDao autoDao;
	
	private AutoServiceImpl() {
		autoDao = AutoDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final AutoServiceImpl INSTANCE = new AutoServiceImpl();
	}

	public static AutoServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fillingListByTheAutoes(Entity entity) {
		return autoDao.fetchListOfTheAutoes(entity); 
	}
}