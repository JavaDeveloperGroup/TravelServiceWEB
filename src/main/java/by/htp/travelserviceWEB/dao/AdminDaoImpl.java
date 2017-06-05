package by.htp.travelserviceWEB.dao;

public class AdminDaoImpl implements AdminDao {

private AdminDaoImpl() {}

private static class Singletone{
private static final AdminDaoImpl INSTANCE = new AdminDaoImpl();
	}

public static AdminDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}