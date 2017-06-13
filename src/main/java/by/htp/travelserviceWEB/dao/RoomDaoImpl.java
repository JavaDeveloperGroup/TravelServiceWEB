package by.htp.travelserviceWEB.dao;

public class RoomDaoImpl implements RoomDao {

private RoomDaoImpl() {}

private static class Singletone{
private static final RoomDaoImpl INSTANCE = new RoomDaoImpl();
	}

public static RoomDaoImpl getInstance() {
return Singletone.INSTANCE;
}
}