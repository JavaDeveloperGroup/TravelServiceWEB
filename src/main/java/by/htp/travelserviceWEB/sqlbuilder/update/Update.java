package by.htp.travelserviceWEB.sqlbuilder.update;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Update extends QueryBuilder {

	private final Query query;
	private final Entity entity;
    private final Map<String, Object> columnsAndValues;
	private String conditionAnd;
    private String conditionOr;

	public Update (Query query, Entity entity) {
		this.query = query;
		this.entity = entity;
		this.query.append("UPDATE ");
        this.query.append(getClassName(entity));
        this.query.append(" SET ");
		this.columnsAndValues = new LinkedHashMap<>();
	}
	
	public Update and(String condition) {
	    this.conditionAnd = condition;
	    query.append(" AND " + conditionAnd);
		return this;
	}

	public Update or(String condition) {
	    this.conditionOr = condition;
	    query.append(" OR " + conditionOr);
        return this;
    }
	
	@Override
	public Update getQuery() 
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

