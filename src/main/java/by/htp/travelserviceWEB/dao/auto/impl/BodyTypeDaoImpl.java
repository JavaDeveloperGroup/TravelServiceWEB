package by.htp.travelserviceWEB.dao.auto.impl;

import by.htp.travelserviceWEB.dao.auto.BodyTypeDao;

public class BodyTypeDaoImpl implements BodyTypeDao {

private BodyTypeDaoImpl() {}

private static class Singletone{
private static final BodyTypeDaoImpl INSTANCE = new BodyTypeDaoImpl();
	}

public static BodyTypeDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}