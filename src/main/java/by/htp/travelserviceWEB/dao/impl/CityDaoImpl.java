package by.htp.travelserviceWEB.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.htp.travelserviceWEB.dao.CityDao;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;

public class CityDaoImpl  implements CityDao {
	
	private CityDaoImpl() {}

	private static class Singletone {
		private static final CityDaoImpl INSTANCE = new CityDaoImpl();
	}

	public static CityDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchCityName(Entity entity) {
		Select select = new QueryBuilder().select(entity).all();
		
		ResultSet rs = null;
		List<Entity> list = null;
		
		try {
			rs = select.resultSet(select.toString());
			list = select.getListOfInstanceWithDataFromSQL(rs, entity);
		} catch (SecurityException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
