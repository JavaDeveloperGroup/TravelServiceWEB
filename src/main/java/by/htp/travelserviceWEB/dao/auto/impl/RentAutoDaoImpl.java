package by.htp.travelserviceWEB.dao.auto.impl;

import by.htp.travelserviceWEB.dao.auto.RentAutoDao;

public class RentAutoDaoImpl implements RentAutoDao {

private RentAutoDaoImpl() {}

private static class Singletone{
private static final RentAutoDaoImpl INSTANCE = new RentAutoDaoImpl();
	}

public static RentAutoDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}