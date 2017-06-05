package by.htp.travelserviceWEB.service;

public class TotalOrderServiceImpl implements TotalOrderService {

private TotalOrderServiceImpl() {}

private static class Singletone{
private static final TotalOrderServiceImpl INSTANCE = new TotalOrderServiceImpl();
	}

public static TotalOrderServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}