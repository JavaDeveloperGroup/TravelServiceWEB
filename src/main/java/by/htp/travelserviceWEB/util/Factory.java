package by.htp.travelserviceWEB.util;

import by.htp.travelserviceWEB.dao.factory.DaoFactory;
import by.htp.travelserviceWEB.service.factory.ServiceFactory;

public class Factory {

	private Factory() {}
	
	private static class Singleton {
		private static final Factory INSTANCE = new Factory();
	}
	
	public static Factory getInstance() {
		return Singleton.INSTANCE;
	}

	public ServiceFactory getServiceFactory() {
		return ServiceFactory.getInstance();
	}
	
	public DaoFactory getDaoFactory() {
		return DaoFactory.getInstance();
	}
}
