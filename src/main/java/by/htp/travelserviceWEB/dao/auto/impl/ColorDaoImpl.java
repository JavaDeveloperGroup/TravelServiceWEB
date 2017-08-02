package by.htp.travelserviceWEB.dao.auto.impl;

import by.htp.travelserviceWEB.dao.auto.ColorDao;

public class ColorDaoImpl implements ColorDao {

	private ColorDaoImpl() {
	}

	private static class Singletone {
		private static final ColorDaoImpl INSTANCE = new ColorDaoImpl();
	}

	public static ColorDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}