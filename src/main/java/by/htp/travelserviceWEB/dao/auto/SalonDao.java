package by.htp.travelserviceWEB.dao.auto;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface SalonDao {
	
	Map<Integer, Entity> fetchListOfTheSalons(Entity entity);
	
}