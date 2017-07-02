package by.htp.travelserviceWEB.dao.tour.impl;

import by.htp.travelserviceWEB.dao.tour.TourOrderDao;

public class TourOrderDaoImpl implements TourOrderDao {

private TourOrderDaoImpl() {}

private static class Singletone{
private static final TourOrderDaoImpl INSTANCE = new TourOrderDaoImpl();
	}

public static TourOrderDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}