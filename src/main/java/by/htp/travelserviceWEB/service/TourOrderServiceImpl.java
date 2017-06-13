package by.htp.travelserviceWEB.service;

public class TourOrderServiceImpl implements TourOrderService {

private TourOrderServiceImpl() {}

private static class Singletone{
private static final TourOrderServiceImpl INSTANCE = new TourOrderServiceImpl();
	}

public static TourOrderServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}