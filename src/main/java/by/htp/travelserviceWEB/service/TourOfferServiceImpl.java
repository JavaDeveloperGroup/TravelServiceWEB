package by.htp.travelserviceWEB.service;

public class TourOfferServiceImpl implements TourOfferService {

private TourOfferServiceImpl() {}

private static class Singletone{
private static final TourOfferServiceImpl INSTANCE = new TourOfferServiceImpl();
	}

public static TourOfferServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}