package by.htp.travelserviceWEB.service;

public class RentAutoServiceImpl implements RentAutoService {

private RentAutoServiceImpl() {}

private static class Singletone{
private static final RentAutoServiceImpl INSTANCE = new RentAutoServiceImpl();
	}

public static RentAutoServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}