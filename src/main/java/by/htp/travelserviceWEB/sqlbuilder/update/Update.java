package by.htp.travelserviceWEB.sqlbuilder.update;

import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.sqlbuilder.Query;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Update extends QueryBuilder {

	private final Query query;
	private EntityAll entityAll;
	private EntityAll entityAllCompare;
    private Map<String, Object> columnsAndValues;
	private String conditionAnd;
    private String conditionOr;

	public Update (Query query, EntityAll entityAll) {
		this.query = query;
		this.entityAll = entityAll;
		this.query.append("UPDATE ");
        this.query.append(getClassName(entityAll));
        this.query.append(" SET ");
		this.columnsAndValues = new LinkedHashMap<>();
	}

	public Update set() {
        try {
            listOfEntityFieldsAndValues(entityAll, entityAllCompare, columnsAndValues);
            query.append(stringWhere(columnsAndValues));
        } catch (IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
	}

	public Update and(String condition) {
	    this.conditionAnd = condition;
        buildAnd();
		return this;
	}

	public Update or(String condition) {
	    this.conditionOr = condition;
        buildOr();
        return this;
    }

	public String getUpdateQuery() {
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

