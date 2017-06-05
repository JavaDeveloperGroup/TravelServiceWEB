package by.htp.travelserviceWEB.service;

public class AutoOrderServiceImpl implements AutoOrderService {

private AutoOrderServiceImpl() {}

private static class Singletone{
private static final AutoOrderServiceImpl INSTANCE = new AutoOrderServiceImpl();
	}

public static AutoOrderServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}