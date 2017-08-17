package by.htp.travelserviceWEB.service.hotel;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface RoomService {
	
	Map<Integer, Entity> fillingListByTheRooms(Entity entity);

}