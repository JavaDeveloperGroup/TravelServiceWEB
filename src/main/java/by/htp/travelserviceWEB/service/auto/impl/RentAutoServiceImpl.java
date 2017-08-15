package by.htp.travelserviceWEB.service.auto.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.auto.RentAutoDao;
import by.htp.travelserviceWEB.dao.auto.impl.RentAutoDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.auto.RentAutoService;

public class RentAutoServiceImpl implements RentAutoService {

	private RentAutoDao rentAutoDao;
	
	private RentAutoServiceImpl() {
		rentAutoDao = RentAutoDaoImpl.getInstance();
	}

	private static class Singletone {
		private static final RentAutoServiceImpl INSTANCE = new RentAutoServiceImpl();
	}

	public static RentAutoServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheRentAutoes(Entity entity) {
		return rentAutoDao.fetchListOfTheRentAutoes(entity);
	}
}