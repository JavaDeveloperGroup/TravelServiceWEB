package by.htp.travelserviceWEB.service;

public class ApartmentServiceImpl implements ApartmentService {

private ApartmentServiceImpl() {}

private static class Singletone{
private static final ApartmentServiceImpl INSTANCE = new ApartmentServiceImpl();
	}

public static ApartmentServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}