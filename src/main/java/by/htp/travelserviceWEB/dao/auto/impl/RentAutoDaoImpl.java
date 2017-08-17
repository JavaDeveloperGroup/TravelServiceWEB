package by.htp.travelserviceWEB.dao.auto.impl;

import static by.htp.travelserviceWEB.util.Formatter.*;

import java.util.List;

import by.htp.travelserviceWEB.dao.auto.RentAutoDao;
import by.htp.travelserviceWEB.entity.Entity;

public class RentAutoDaoImpl implements RentAutoDao {
	
	private RentAutoDaoImpl() {
	}

	private static class Singletone {
		private static final RentAutoDaoImpl INSTANCE = new RentAutoDaoImpl();
	}

	public static RentAutoDaoImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fetchListOfTheRentAutoes(Entity entity) {
		return extractionEntities(entity);
	}
}