package by.htp.travelserviceWEB.sqlbuilder.select;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.entity.dto.EntityTO;
import by.htp.travelserviceWEB.sqlbuilder.Query;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;

import java.util.Map;

public final class Select {

	private final Query query;
	private final Map<String, Object> entityMap;
	private final Map<String, Object> entityTOMap;
	private final EntityAll entityAll;
	private final EntityAll entityAllCompare;
	private EntityTO entityTO;
	
	public Select (Query query, EntityAll entityAll, EntityAll entityAllCompare) {
		this.query = query;
		this.entityAll = entityAll;
		this.entityAllCompare = entityAllCompare;
		this.entityMap = new LinkedHashMap<>();
		this.entityTOMap = new LinkedHashMap<>();
	}
	
	public Select (Query query, EntityAll entityAll, EntityTO entityTO, EntityAll entityAllCompare) {
		this(query, entityAll, entityAllCompare);
		this.entityTO = entityTO;
		this.query.append("SELECT ");
	}

	public String getSelectQuery() {
		buildSelectForFetchUsers();
		fetch();
		return query.getSQLQuery().toString();
	}
	
	private void buildSelectForFetchUsers() {
		try {
			listOfEntityFieldsAndValues(entityAll, entityAllCompare, entityMap);
			listOfEntityFieldsAndValues(entityTO, entityAllCompare, entityTOMap);
		} catch (SecurityException | ClassNotFoundException 
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void fetch() {
		try {
			String columns = stringOfColumns(entityMap);
					query.append("*")
						 .append(" FROM ")
						 .append(getClassName(entityAll))
						 .append(" WHERE")
						 .append(conditions());
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private String conditions() {
		StringBuilder condition = new StringBuilder();
		int i = 0;
		for (Map.Entry<String, Object> map : entityTOMap.entrySet()) {
			i++;
			if (i > 1 && i < entityTOMap.size()) {
				condition.append(" ")
						 .append(getClassName(entityAll))
						 .append(".")
						 .append(map.getKey())
						 .append(" = ")
						 .append(framing(map.getValue()))
						 .append(" AND ");
			}
			if (i == entityTOMap.size()) {
				condition.append(" ")
						 .append(getClassName(entityAll))
						 .append(".")
						 .append(map.getKey())
						 .append(" = ")
						 .append(framing(map.getValue()));
			}
		}
		
		return condition.toString();
	}
}
