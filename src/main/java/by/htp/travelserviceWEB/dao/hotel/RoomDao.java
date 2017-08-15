package by.htp.travelserviceWEB.dao.hotel;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface RoomDao {
	
	Map<Integer, Entity> fetchListOfTheRooms(Entity entity);

}