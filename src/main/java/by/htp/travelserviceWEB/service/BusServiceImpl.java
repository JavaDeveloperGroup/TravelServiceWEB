package by.htp.travelserviceWEB.service;

public class BusServiceImpl implements BusService {

private BusServiceImpl() {}

private static class Singletone{
private static final BusServiceImpl INSTANCE = new BusServiceImpl();
	}

public static BusServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}