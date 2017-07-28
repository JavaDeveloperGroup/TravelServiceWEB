package by.htp.travelserviceWEB.dao;

import by.htp.travelserviceWEB.entity.Entity;

public interface EntityDao {
	
		public Entity select(Entity entity);
		public Entity insert(Entity entity);
		public Entity update(Entity entity);
		public Entity delete(Entity entity);
		
}
