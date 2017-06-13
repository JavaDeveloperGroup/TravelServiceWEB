package by.htp.travelserviceWEB.service;

public class HotelServiceImpl implements HotelService {

private HotelServiceImpl() {}

private static class Singletone{
private static final HotelServiceImpl INSTANCE = new HotelServiceImpl();
	}

public static HotelServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}