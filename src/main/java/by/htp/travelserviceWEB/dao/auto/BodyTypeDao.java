package by.htp.travelserviceWEB.dao.auto;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface BodyTypeDao {

	Map<Integer, Entity> fetchListOfTheBodyTypes(Entity entity);
	
}