package by.htp.travelserviceWEB.service.hotel.impl;

import by.htp.travelserviceWEB.service.hotel.ApartmentService;

public class ApartmentServiceImpl implements ApartmentService {

	private ApartmentServiceImpl() {}

	private static class Singletone{
		private static final ApartmentServiceImpl INSTANCE = new ApartmentServiceImpl();
	}

	public static ApartmentServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}
}