package by.htp.travelserviceWEB.sqlbuilder.delete;

import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.sqlbuilder.Query;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Delete {

	private final Query query;
	private final EntityAll entityAll;
	private EntityAll entityAllCompare;
	private Map<String, Object> columnsAndValues;
	private String conditionAnd;
	private String conditionOr;
	
	public Delete (Query query, EntityAll entityAll) {
		this.query = query;
		this.entityAll = entityAll;
		this.query.append("DELETE FROM ");
		this.query.append(getClassName(entityAll));
		this.columnsAndValues = new LinkedHashMap<>();
	}

	public Delete where() {
		try {
			listOfEntityFieldsAndValues(entityAll, entityAllCompare, columnsAndValues);
			query.append(stringWhere(columnsAndValues));
		} catch (ClassNotFoundException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return this;
	}

	public Delete and(String condition) {
		this.conditionAnd = condition;
		buildAnd();
		return this;
	}

	public Delete or(String condition) {
		this.conditionAnd = condition;
		buildOr();
		return this;
	}

	public String getDeleteQuery() {
		query.append(";");
		return query.getSQLQuery().toString();
	}

	private void buildAnd() {
		query.append(" AND " + conditionAnd);
	}

	private void buildOr() {
		query.append(" OR " + conditionOr);
	}
}

