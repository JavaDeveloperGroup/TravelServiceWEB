package by.htp.travelserviceWEB.dao.auto;

import java.util.List;

import by.htp.travelserviceWEB.entity.Entity;

public interface BodyTypeDao {

	List<Entity> fetchListOfTheBodyTypes(Entity entity);
	
}