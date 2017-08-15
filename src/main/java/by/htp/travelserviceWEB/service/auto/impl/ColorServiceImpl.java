package by.htp.travelserviceWEB.service.auto.impl;

import java.util.Map;

import by.htp.travelserviceWEB.dao.auto.ColorDao;
import by.htp.travelserviceWEB.dao.auto.impl.ColorDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.ColorService;

public class ColorServiceImpl implements ColorService {

	private ColorDao colorDao;
	
	private ColorServiceImpl() {
		colorDao = ColorDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final ColorServiceImpl INSTANCE = new ColorServiceImpl();
	}

	public static ColorServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public Map<Integer, Entity> fillingListByTheColors(Entity entity) {
		return colorDao.fetchListOfTheColors(entity);
	}
}