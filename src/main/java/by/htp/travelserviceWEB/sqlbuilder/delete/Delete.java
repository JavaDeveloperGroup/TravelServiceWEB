package by.htp.travelserviceWEB.sqlbuilder.delete;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Delete extends QueryBuilder {

	private Query query;
	private Entity entity;
	private Map<String, Object> columnsAndValues;
	
	public Delete (Query query) {
		this.query = query;
		this.query.append("DELETE ");
	}
	
	public Delete (Query query, Entity entity) {
		this(query);
		this.entity = entity;
		this.query.append(" FROM ");
		this.query.append(getClassName(entity));
		this.columnsAndValues = new LinkedHashMap<>();
	}
	
	public Delete all() {
		this.query.append(" * ");
		return this;
	}
	
	public Delete from() {
		this.query.append(" FROM ");
		return this;
	}
	
	public Delete where(String ... conditions) {
		return this;
	}
	
	public Delete table(String tableName, String ... tableNames) {
		return this;
	}
	
	public Delete orderBy(String columnName) {
		this.query.append(columnName);
		return this;
	}
	
	public Delete limit(String count) {
		this.query.append(count);
		return this;
	}
	
	public Delete and(String condition) {
		query.append(" AND " + condition);
		return this;
	}

	public Delete or(String condition) {
		query.append(" OR " + condition);
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
		return query.getSQLQuery();
	}
}

