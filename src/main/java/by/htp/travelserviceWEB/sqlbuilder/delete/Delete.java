package by.htp.travelserviceWEB.sqlbuilder.delete;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Delete extends QueryBuilder {

	private final Query query;
	private final Entity entity;
	private final Map<String, Object> columnsAndValues;
	private String conditionAnd;
	private String conditionOr;
	
	public Delete (Query query, Entity entity) {
		this.query = query;
		this.entity = entity;
		this.query.append("DELETE FROM ").append(getClassName(entity));
		this.columnsAndValues = new LinkedHashMap<>();
	}
	
	public Delete and(String condition) {
		this.conditionAnd = condition;
		query.append(" AND " + conditionAnd);
		return this;
	}

	public Delete or(String condition) {
		this.conditionAnd = condition;
		query.append(" OR " + conditionOr);
		return this;
	}
	
	@Override
	public Delete getQuery() 
			throws SecurityException, ClassNotFoundException, 
			IllegalArgumentException, IllegalAccessException {
		
		listOfEntityFieldsAndValues(entity, columnsAndValues);
		query.append(stringWhereForUpdateAndDelete(entity, columnsAndValues));
        
        return this;
	}
	
	@Override
	public String toString() {
		return query.getSQLQuery().toString();
	}
}

