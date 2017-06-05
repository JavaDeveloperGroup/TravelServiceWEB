package by.htp.travelserviceWEB.dao;

public class AutoDaoImpl implements AutoDao {

private AutoDaoImpl() {}

private static class Singletone{
private static final AutoDaoImpl INSTANCE = new AutoDaoImpl();
	}

public static AutoDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}