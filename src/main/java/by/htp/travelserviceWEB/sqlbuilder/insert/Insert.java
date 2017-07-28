package by.htp.travelserviceWEB.sqlbuilder.insert;

import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.sqlbuilder.Query;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Insert {
	
	private final Query query;
	private final Map<String, Object> columnsAndValues;
	private final EntityAll entityAll;
	private final EntityAll entityAllCompare;

	public Insert (Query query, EntityAll entityAll, EntityAll entityAllCompare) {
        this.query = query;
		this.entityAll = entityAll;
		this.entityAllCompare = entityAllCompare;
        this.columnsAndValues = new LinkedHashMap<>();
	}

	public String getInsertQuery() {
        buildInsert();
		return query.getSQLQuery().toString();
	}
	
	private void buildInsert() {
		try {
            listOfEntityFieldsAndValues(entityAll, entityAllCompare, columnsAndValues);
		} catch (SecurityException | ClassNotFoundException 
				| IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		try {
			query.append("INSERT INTO ")
					.append(getClassName(entityAll))
					.append(" (" + stringOfColumns(columnsAndValues) + ") ")
					.append("VALUES ")
					.append("(" + stringOfValues(columnsAndValues) + ");");

		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
