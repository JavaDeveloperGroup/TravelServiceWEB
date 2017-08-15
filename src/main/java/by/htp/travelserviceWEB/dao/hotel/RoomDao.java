package by.htp.travelserviceWEB.dao.hotel;

import java.util.List;

import by.htp.travelserviceWEB.entity.Entity;

public interface RoomDao {
	
	List<Entity> fetchListOfTheRooms(Entity entity);

}