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
	private final Map<String, Object> entityMap;
	private final Map<String, Object> conditionsMap;
	private final Entity entity;
	private CustomerTOLP customerTOLP;
	
	public Select (Query query, Entity entity) {
		this.query = query;
		this.entity = entity;
		this.query.append("SELECT ");
		this.entityMap = new LinkedHashMap<>();
		this.conditionsMap = new LinkedHashMap<>();
	}
	
	public Select (Query query, Entity entity, CustomerTOLP customerTOLP) {
		this(query, entity);
		this.customerTOLP = customerTOLP;
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
