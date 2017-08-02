package by.htp.travelserviceWEB.sqlbuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import by.htp.travelserviceWEB.connector.ConnectionPool;
import by.htp.travelserviceWEB.entity.Entity;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class Query {
	
	private final ConnectionPool connector = ConnectionPool.getInstance();
	private final Connection connection;
	private final StringBuilder sql;
	
	public Query() {
		connection = connector.getConnection();
		sql = new StringBuilder();
	}
	
	public final Query append(String expression) {
		sql.append(expression);
		
		return this;
	}

	public final String getSQLQuery() {
		
		return sql.toString();
	}
	
	public final ResultSet resultSet(String sqlQuery) 
			throws SQLException, SecurityException, ClassNotFoundException {
		ResultSet resultSet;
		PreparedStatement statement = prepareStatement(sqlQuery);

		resultSet = statement.executeQuery();
		
		return resultSet;
	}
	
	public final PreparedStatement prepareStatement(String sqlQuery)
			throws SQLException, SecurityException, ClassNotFoundException {

		PreparedStatement statement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		connector.putBack(connection);

		return statement;
	}
	
	public Query getQuery() 
			throws SecurityException, ClassNotFoundException, 
			IllegalArgumentException, IllegalAccessException {
		
		return this;
	}
	
	public Object getInstanceWithDataFromSQL(ResultSet resultSet, Entity entity) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		Object[] obj = new Object[getConstructor(entity)[1].getParameters().length];
		
		if (resultSet.next()) {
			for(int i = 1, o = 0, l = obj.length; i <= l; i++, o++) {
				obj[o] = resultSet.getObject(i);
			}
			return newInstance(entity, obj);
		} else {
			return null;
		}

		
	}
}






























