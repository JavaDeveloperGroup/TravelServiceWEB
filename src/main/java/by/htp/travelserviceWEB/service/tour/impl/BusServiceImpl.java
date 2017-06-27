package by.htp.travelserviceWEB.service.tour.impl;

import by.htp.travelserviceWEB.service.tour.BusService;

public class BusServiceImpl implements BusService {

private BusServiceImpl() {}

private static class Singletone{
private static final BusServiceImpl INSTANCE = new BusServiceImpl();
	}

public static BusServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}