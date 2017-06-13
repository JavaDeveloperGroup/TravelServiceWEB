package by.htp.travelserviceWEB.dao;

public class HotelDaoImpl implements HotelDao {

private HotelDaoImpl() {}

private static class Singletone{
private static final HotelDaoImpl INSTANCE = new HotelDaoImpl();
	}

public static HotelDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}