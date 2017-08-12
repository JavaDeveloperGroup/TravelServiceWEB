package by.htp.travelserviceWEB.sqlbuilder;

public class Query {

	private final StringBuilder sql;
	
	public Query() {
		sql = new StringBuilder();
	}
	
	public final Query append(String expression) {
		sql.append(expression);
		return this;
	}

	public final String getSQLQuery() {
		return sql.toString();
	}
}
