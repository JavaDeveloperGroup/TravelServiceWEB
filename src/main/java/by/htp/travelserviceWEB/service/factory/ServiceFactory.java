package by.htp.travelserviceWEB.service.factory;

import by.htp.travelserviceWEB.service.UserService;
import by.htp.travelserviceWEB.service.auto.AutoService;
import by.htp.travelserviceWEB.service.auto.impl.AutoServiceImpl;
import by.htp.travelserviceWEB.service.hotel.ApartmentService;
import by.htp.travelserviceWEB.service.hotel.impl.ApartmentServiceImpl;
import by.htp.travelserviceWEB.service.impl.UserServiceImpl;
import by.htp.travelserviceWEB.service.tour.TourOfferService;
import by.htp.travelserviceWEB.service.tour.impl.TourOfferServiceImpl;

public class ServiceFactory {

	private ServiceFactory() {}
	
	private static class Singletone{
		private static final ServiceFactory INSTANCE = new ServiceFactory();
	}
	
	public static ServiceFactory getInstance() {
		return Singletone.INSTANCE;
	}
	
	public UserService getUserService() {
		return UserServiceImpl.getInstance();
	}
	
	public ApartmentService getApartmentService() {
		return ApartmentServiceImpl.getInstance();
	}
	
	public TourOfferService getTourOfferService() {
		return TourOfferServiceImpl.getInstance();
	}
	
	public AutoService getAutoService() {
		return AutoServiceImpl.getInstance();
	}
	
}
