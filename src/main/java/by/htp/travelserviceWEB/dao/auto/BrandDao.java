package by.htp.travelserviceWEB.dao.auto;

import java.util.Map;

import by.htp.travelserviceWEB.entity.Entity;

public interface BrandDao {

	Map<Integer, Entity> fetchListOfTheBrands(Entity entity);
	
}