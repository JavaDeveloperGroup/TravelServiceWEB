package by.htp.travelserviceWEB.service;

public class HotelOrderServiceImpl implements HotelOrderService {

private HotelOrderServiceImpl() {}

private static class Singletone{
private static final HotelOrderServiceImpl INSTANCE = new HotelOrderServiceImpl();
	}

public static HotelOrderServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}