package by.htp.travelserviceWEB.dao;

public class BusDaoImpl implements BusDao {

private BusDaoImpl() {}

private static class Singletone{
private static final BusDaoImpl INSTANCE = new BusDaoImpl();
	}

public static BusDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}