package by.htp.travelserviceWEB.dao.auto.impl;

import by.htp.travelserviceWEB.dao.auto.AutoOrderDao;

public class AutoOrderDaoImpl implements AutoOrderDao {

	private AutoOrderDaoImpl() {
	}

	private static class Singletone {
		private static final AutoOrderDaoImpl INSTANCE = new AutoOrderDaoImpl();
	}

	public static AutoOrderDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}
}