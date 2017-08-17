package by.htp.travelserviceWEB.service;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface CityService {
	
	Map<Integer, Entity> fillingListByTheCities(Entity entity);
	
}
