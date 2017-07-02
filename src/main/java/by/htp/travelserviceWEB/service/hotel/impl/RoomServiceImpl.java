package by.htp.travelserviceWEB.service.hotel.impl;

import by.htp.travelserviceWEB.service.hotel.RoomService;

public class RoomServiceImpl implements RoomService {

private RoomServiceImpl() {}

private static class Singletone{
private static final RoomServiceImpl INSTANCE = new RoomServiceImpl();
	}

public static RoomServiceImpl getInstance() {
return Singletone.INSTANCE;
}
}