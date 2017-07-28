package by.htp.travelserviceWEB.service.impl;

import by.htp.travelserviceWEB.service.TotalOrderService;

public class TotalOrderServiceImpl implements TotalOrderService {

	private TotalOrderServiceImpl() {
	}

	private static class Singletone {
		private static final TotalOrderServiceImpl INSTANCE = new TotalOrderServiceImpl();
	}

	public static TotalOrderServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
}