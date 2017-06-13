package by.htp.travelserviceWEB.service;

public class AutoServiceImpl implements AutoService {

private AutoServiceImpl() {}

private static class Singletone{
private static final AutoServiceImpl INSTANCE = new AutoServiceImpl();
	}

public static AutoServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}