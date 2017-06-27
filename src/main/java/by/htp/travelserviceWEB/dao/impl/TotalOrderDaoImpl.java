package by.htp.travelserviceWEB.dao.impl;

import by.htp.travelserviceWEB.dao.TotalOrderDao;

public class TotalOrderDaoImpl implements TotalOrderDao {

private TotalOrderDaoImpl() {}

private static class Singletone{
private static final TotalOrderDaoImpl INSTANCE = new TotalOrderDaoImpl();
	}

public static TotalOrderDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}