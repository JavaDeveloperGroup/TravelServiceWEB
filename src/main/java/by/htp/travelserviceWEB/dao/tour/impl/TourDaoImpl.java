package by.htp.travelserviceWEB.dao.tour.impl;

import by.htp.travelserviceWEB.dao.tour.TourDao;

public class TourDaoImpl implements TourDao {

private TourDaoImpl() {}

private static class Singletone{
private static final TourDaoImpl INSTANCE = new TourDaoImpl();
	}

public static TourDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}