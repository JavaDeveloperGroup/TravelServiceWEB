package by.htp.travelserviceWEB.sqlbuilder.builder;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.entity.dto.EntityTO;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.delete.Delete;
import by.htp.travelserviceWEB.sqlbuilder.insert.Insert;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;
import by.htp.travelserviceWEB.sqlbuilder.update.Update;

public class QueryBuilder {
	
	private Query query;

	public QueryBuilder() {
		this.query = new Query();
	}
	
	public Select select(Entity entity, EntityAll entityAllCompare) {
		return new Select(query, entity, entityAllCompare);
	}
	
	public Select selectFetchUser(Entity entity, CustomerTOLP customerTOLP, EntityAll entityAllCompare) {
		return new Select(query, entity, customerTOLP, entityAllCompare);
	}

	public Insert insert(EntityAll entityAll, EntityAll entityAllCompare) {
		return new Insert(query, entityAll, entityAllCompare);
	}
	
	public Update update(Entity entity) {
		return new Update(query, entity);
	}
	
	public Delete delete(Entity entity) {
		return new Delete(query, entity);
	}
}
