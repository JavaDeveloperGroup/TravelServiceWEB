package by.htp.travelserviceWEB.service.tour.impl;

import by.htp.travelserviceWEB.service.tour.TourService;

public class TourServiceImpl implements TourService {

private TourServiceImpl() {}

private static class Singletone{
private static final TourServiceImpl INSTANCE = new TourServiceImpl();
	}

public static TourServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}