package by.htp.travelserviceWEB.dao.factory;

import by.htp.travelserviceWEB.dao.UserDao;
import by.htp.travelserviceWEB.dao.auto.AutoDao;
import by.htp.travelserviceWEB.dao.auto.impl.AutoDaoImpl;
import by.htp.travelserviceWEB.dao.hotel.ApartmentDao;
import by.htp.travelserviceWEB.dao.hotel.impl.ApartmentDaoImpl;
import by.htp.travelserviceWEB.dao.impl.UserDaoImpl;
import by.htp.travelserviceWEB.dao.tour.TourOfferDao;
import by.htp.travelserviceWEB.dao.tour.impl.TourOfferDaoImpl;

public class DaoFactory {

	private DaoFactory() {}
	
	private static class Singletone{
		private static final DaoFactory INSTANCE = new DaoFactory();
	}
	
	public static DaoFactory getInstance() {
		return Singletone.INSTANCE;
	}
	
	public UserDao getUserService() {
		return UserDaoImpl.getInstance();
	}
	
	public ApartmentDao getApartmentService() {
		return ApartmentDaoImpl.getInstance();
	}
	
	public TourOfferDao getTourOfferService() {
		return TourOfferDaoImpl.getInstance();
	}
	
	public AutoDao getAutoService() {
		return AutoDaoImpl.getInstance();
	}
	
}
