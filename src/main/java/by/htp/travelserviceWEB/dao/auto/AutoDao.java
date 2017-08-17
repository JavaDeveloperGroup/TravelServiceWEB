package by.htp.travelserviceWEB.dao.auto;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface AutoDao {
	
	Map<Integer, Entity> fetchListOfTheAutoes(Entity entity);

}