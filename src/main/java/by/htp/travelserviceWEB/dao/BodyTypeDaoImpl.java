package by.htp.travelserviceWEB.dao;

public class BodyTypeDaoImpl implements BodyTypeDao {

private BodyTypeDaoImpl() {}

private static class Singletone{
private static final BodyTypeDaoImpl INSTANCE = new BodyTypeDaoImpl();
	}

public static BodyTypeDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}