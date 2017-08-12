package by.htp.travelserviceWEB.sqlbuilder.insert;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Insert extends QueryBuilder {
	
	private final Query query;
	private final Map<String, Object> columnsAndValues;
	private final Entity entity;

	public Insert (Query query, Entity entity) {
        this.query = query;
		this.entity = entity;
		this.query.append("INSERT INTO ").append(getClassName(entity));
        this.columnsAndValues = new LinkedHashMap<>();
	}

	@Override
	public Insert getQuery() 
			throws SecurityException, ClassNotFoundException, 
			IllegalArgumentException, IllegalAccessException {
		
		listOfEntityFieldsAndValues(entity, columnsAndValues);
        query.append(stringInsert(entity, columnsAndValues));
        
        return this;
	}
	
	@Override
	public String toString() {
		return query.getSQLQuery().toString();
	}
}
