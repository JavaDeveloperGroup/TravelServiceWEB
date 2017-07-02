package by.htp.travelserviceWEB.dao.tour.impl;

import by.htp.travelserviceWEB.dao.tour.BusDao;

public class BusDaoImpl implements BusDao {

private BusDaoImpl() {}

private static class Singletone{
private static final BusDaoImpl INSTANCE = new BusDaoImpl();
	}

public static BusDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}