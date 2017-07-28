package by.htp.travelserviceWEB.sqlbuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.htp.travelserviceWEB.connector.ConnectionPool;

public final class Query {
	
	private final ConnectionPool connector = ConnectionPool.getInstance();
	private final Connection connection;
	private StringBuilder sql;
	private final Map<String, Object> columnsAndValues;
	
	public Query() {
		connection = connector.getConnection();
		sql = new StringBuilder();
		columnsAndValues = new LinkedHashMap<>();
	}
	
	public Query append(String expression) {
		sql.append(expression);
		return this;
	}

	public String getSQLQuery() {
		String sqlToStr = sql.toString();
		sql = new StringBuilder();
		return sqlToStr;
	}
	
	public ResultSet resultSet(String sqlQuery) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		//try() {
			PreparedStatement statement = prepareStatement(sqlQuery);
			return statement.executeQuery();
		//}
	}
	
	public PreparedStatement prepareStatement(String sqlQuery) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		PreparedStatement statement =  connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);		
		connector.putBack(connection);
		
		return statement;
	}
}






























