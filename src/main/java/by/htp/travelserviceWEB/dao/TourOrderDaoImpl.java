package by.htp.travelserviceWEB.dao;

public class TourOrderDaoImpl implements TourOrderDao {

private TourOrderDaoImpl() {}

private static class Singletone{
private static final TourOrderDaoImpl INSTANCE = new TourOrderDaoImpl();
	}

public static TourOrderDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}