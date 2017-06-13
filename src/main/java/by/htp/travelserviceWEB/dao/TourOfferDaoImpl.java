package by.htp.travelserviceWEB.dao;

public class TourOfferDaoImpl implements TourOfferDao {

private TourOfferDaoImpl() {}

private static class Singletone{
private static final TourOfferDaoImpl INSTANCE = new TourOfferDaoImpl();
	}

public static TourOfferDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}