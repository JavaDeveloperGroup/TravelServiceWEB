package by.htp.travelserviceWEB.service.auto.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.auto.BodyTypeDao;
import by.htp.travelserviceWEB.dao.auto.impl.BodyTypeDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.BodyTypeService;

public class BodyTypeServiceImpl implements BodyTypeService {

	private BodyTypeDao bodyTypeDao;
	
	private BodyTypeServiceImpl() {
		bodyTypeDao = BodyTypeDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final BodyTypeServiceImpl INSTANCE = new BodyTypeServiceImpl();
	}

	public static BodyTypeServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheBodyTypes(Entity entity) {
		return bodyTypeDao.fetchListOfTheBodyTypes(entity);
	}
}