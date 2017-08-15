package by.htp.travelserviceWEB.service.hotel;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface HotelService {
	
	Map<Integer, Entity> fillingListByTheHotels(Entity entity);

}