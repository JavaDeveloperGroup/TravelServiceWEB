package by.htp.travelserviceWEB.service.auto.impl;

import java.util.List;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.ColorService;

public class ColorServiceImpl implements ColorService {

	private ColorServiceImpl() {
	}

	private static class Singletone {
		private static final ColorServiceImpl INSTANCE = new ColorServiceImpl();
	}

	public static ColorServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheColors(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}