package by.htp.travelserviceWEB.dao.auto.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.htp.travelserviceWEB.dao.auto.SalonDao;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;

public class SalonDaoImpl implements SalonDao {

	private SalonDaoImpl() {
	}

	private static class Singletone {
		private static final SalonDaoImpl INSTANCE = new SalonDaoImpl();
	}

	public static SalonDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchSalonName(Entity entity) {
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