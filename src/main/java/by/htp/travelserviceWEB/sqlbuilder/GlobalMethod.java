package by.htp.travelserviceWEB.sqlbuilder;

import static by.htp.travelserviceWEB.util.Formatter.getConstructor;
import static by.htp.travelserviceWEB.util.Formatter.newInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import by.htp.travelserviceWEB.connector.ConnectionPool;
import by.htp.travelserviceWEB.entity.Entity;

public abstract class GlobalMethod {
	
	private final ConnectionPool connector = ConnectionPool.getInstance();
	
	public GlobalMethod getQuery() throws SecurityException, ClassNotFoundException, 
							IllegalArgumentException, IllegalAccessException {
		return this;
	}
	
	public final ResultSet resultSet(String sqlQuery) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		PreparedStatement statement = prepareStatement(sqlQuery);

		ResultSet resultSet = statement.executeQuery();	
		return resultSet;
	}
	
	public final PreparedStatement prepareStatement(String sqlQuery)
			throws SQLException, SecurityException, ClassNotFoundException {
		
		Connection connection = connector.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		
		connector.putBack(connection);
		return statement;
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
	
	public List<Entity> getListOfInstanceWithDataFromSQL(ResultSet resultSet, Entity entity) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		Object[] obj = new Object[getConstructor(entity)[1].getParameters().length];
		List<Entity> list = new LinkedList<>();
		
		while (resultSet.next()) {
			for(int i = 1, o = 0, l = obj.length; i <= l; i++, o++) {
				obj[o] = resultSet.getObject(i);
			}
			list.add((Entity) newInstance(entity, obj));
		}
		return list;
	}
	
	public Map<Integer, Entity> getMapOfInstanceWithDataFromSQL(ResultSet resultSet, Entity entity) 
			throws SQLException, SecurityException, ClassNotFoundException {
		
		Object[] obj = new Object[getConstructor(entity)[1].getParameters().length];
		Map<Integer, Entity> map = new HashMap<>();
		
		while (resultSet.next()) {
			for(int i = 1, o = 0, l = obj.length; i <= l; i++, o++) {
				obj[o] = resultSet.getObject(i);
			}
			map.put((Integer) obj[0], (Entity) newInstance(entity, obj));
		}
		return map;
	}
}
