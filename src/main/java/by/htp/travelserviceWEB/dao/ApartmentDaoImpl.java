package by.htp.travelserviceWEB.dao;

public class ApartmentDaoImpl implements ApartmentDao {

private ApartmentDaoImpl() {}

private static class Singletone{
private static final ApartmentDaoImpl INSTANCE = new ApartmentDaoImpl();
	}

public static ApartmentDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}