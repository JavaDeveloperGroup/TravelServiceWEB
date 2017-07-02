package by.htp.travelserviceWEB.dao.tour.impl;

import by.htp.travelserviceWEB.dao.tour.TourOfferDao;

public class TourOfferDaoImpl implements TourOfferDao {

private TourOfferDaoImpl() {}

private static class Singletone{
private static final TourOfferDaoImpl INSTANCE = new TourOfferDaoImpl();
	}

public static TourOfferDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}