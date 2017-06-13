package by.htp.travelserviceWEB.dao;

public class HotelOrderDaoImpl implements HotelOrderDao {

private HotelOrderDaoImpl() {}

private static class Singletone{
private static final HotelOrderDaoImpl INSTANCE = new HotelOrderDaoImpl();
	}

public static HotelOrderDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}