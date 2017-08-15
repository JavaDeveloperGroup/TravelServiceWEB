package by.htp.travelserviceWEB.dao.auto;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface ColorDao {

	Map<Integer, Entity> fetchListOfTheColors(Entity entity);
	
}