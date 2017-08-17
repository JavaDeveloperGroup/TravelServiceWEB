package by.htp.travelserviceWEB.dao;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface CityDao {
	
	Map<Integer, Entity> fetchListOfTheCities(Entity entity);
	
}
