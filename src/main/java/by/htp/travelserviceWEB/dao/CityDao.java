package by.htp.travelserviceWEB.dao;

import java.util.List;

import by.htp.travelserviceWEB.entity.Entity;

public interface CityDao {
	
	List<Entity> fetchListOfTheCities(Entity entity);
	
}
