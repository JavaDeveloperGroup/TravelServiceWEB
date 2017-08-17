package by.htp.travelserviceWEB.service.auto.impl;

import by.htp.travelserviceWEB.service.auto.AutoOrderService;

public class AutoOrderServiceImpl implements AutoOrderService {

	private AutoOrderServiceImpl() {
	}

	private static class Singletone {
		private static final AutoOrderServiceImpl INSTANCE = new AutoOrderServiceImpl();
	}

	public static AutoOrderServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
}