package by.htp.travelserviceWEB.dao.hotel.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.htp.travelserviceWEB.dao.hotel.ApartmentDao;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.sqlbuilder.builder.QueryBuilder;
import by.htp.travelserviceWEB.sqlbuilder.select.Select;

public class ApartmentDaoImpl implements ApartmentDao {

	private ApartmentDaoImpl() {}

	private static class Singletone {
		private static final ApartmentDaoImpl INSTANCE = new ApartmentDaoImpl();
	}

	public static ApartmentDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchApartmentName(Entity entity) {
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