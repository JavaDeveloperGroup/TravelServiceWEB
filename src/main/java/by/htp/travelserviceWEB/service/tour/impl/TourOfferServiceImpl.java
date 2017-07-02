package by.htp.travelserviceWEB.service.tour.impl;

import by.htp.travelserviceWEB.service.tour.TourOfferService;

public class TourOfferServiceImpl implements TourOfferService {

private TourOfferServiceImpl() {}

private static class Singletone{
private static final TourOfferServiceImpl INSTANCE = new TourOfferServiceImpl();
	}

public static TourOfferServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}