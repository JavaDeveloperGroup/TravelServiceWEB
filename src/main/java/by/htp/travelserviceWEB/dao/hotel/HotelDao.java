package by.htp.travelserviceWEB.dao.hotel;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface HotelDao {
	
	Map<Integer, Entity> fetchListOfTheHotels(Entity entity);

}