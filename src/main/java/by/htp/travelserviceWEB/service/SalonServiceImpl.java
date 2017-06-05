package by.htp.travelserviceWEB.service;

public class SalonServiceImpl implements SalonService {

private SalonServiceImpl() {}

private static class Singletone{
private static final SalonServiceImpl INSTANCE = new SalonServiceImpl();
	}

public static SalonServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}