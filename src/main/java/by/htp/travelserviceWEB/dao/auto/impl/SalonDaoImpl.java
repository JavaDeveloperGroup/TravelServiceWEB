package by.htp.travelserviceWEB.dao.auto.impl;

import by.htp.travelserviceWEB.dao.auto.SalonDao;

public class SalonDaoImpl implements SalonDao {

private SalonDaoImpl() {}

private static class Singletone{
private static final SalonDaoImpl INSTANCE = new SalonDaoImpl();
	}

public static SalonDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}