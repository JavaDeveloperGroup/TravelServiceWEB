package by.htp.travelserviceWEB.sqlbuilder.select;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;

import java.util.Map;

public final class Select extends QueryBuilder {

	private final Query query;
	private Map<String, Object> entityMap;
	private Map<String, Object> conditionsMap;
	private Entity entity;
	private Entity[] entities;
	private CustomerTOLP customerTOLP;
	
	public Select (Query query) {
		this.query = query;
		this.query.append("SELECT ");
		this.entityMap = new LinkedHashMap<>();
		this.conditionsMap = new LinkedHashMap<>();
	}
	
	public Select (Query query, Entity entity) {
		this(query);
		this.entity = entity;
	}
	
	public Select (Query query, Entity entity, CustomerTOLP customerTOLP) {
		this(query, entity);
		this.customerTOLP = customerTOLP;
	}
	
	public Select (Query query, Entity ... entities) {
		this(query);
		this.entities = entities;
	}
	
	public Select all() {
		query.append(" * ")
			 .append("FROM ")
			 .append(entity.getClass().getSimpleName().toLowerCase());
		return this;
	}

	public Select from() {
		return this;
	}
	
	public Select fetchCustomerOrAdmin() 
			throws SecurityException, ClassNotFoundException, 
				   IllegalArgumentException, IllegalAccessException {
		
		fieldsAndValuesListFormation(entity, customerTOLP, entityMap, conditionsMap);
		fromWhere(query, entity, entityMap);
		fromWhereForChecking(query, entity, conditionsMap);
		return this;
	}
	
	public Select and() {
		return this;
	}
	
	@Override
	public Select getQuery() 
			throws SecurityException, ClassNotFoundException, 
			IllegalArgumentException, IllegalAccessException {
        
        return this;
	}
	
	@Override
	public String toString() {
		return query.getSQLQuery().toString();
	}
}