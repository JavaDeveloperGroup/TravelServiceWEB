package by.htp.travelserviceWEB.sqlbuilder.builder;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.delete.Delete;
import by.htp.travelserviceWEB.sqlbuilder.insert.Insert;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;
import by.htp.travelserviceWEB.sqlbuilder.update.Update;

public class QueryBuilder extends Query{
	
	private final Query query;

	public QueryBuilder() {
		this.query = new Query();
	}
	
	public final Select select(Entity entity) {
		return new Select(query, entity);
	}
	
	public final Select selectFetchUser(Entity entity, CustomerTOLP customerTOLP) {
		return new Select(query, entity, customerTOLP);
	}

	public final Insert insert(Entity entity) {
		return new Insert(query, entity);
	}
	
	public final Update update(Entity entity) {
		return new Update(query, entity);
	}
	
	public final Delete delete(Entity entity) {
		return new Delete(query, entity);
	}
}
