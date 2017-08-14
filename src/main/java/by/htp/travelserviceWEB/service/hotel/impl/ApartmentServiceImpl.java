package by.htp.travelserviceWEB.service.hotel.impl;

import java.util.List;

import by.htp.travelserviceWEB.dao.hotel.ApartmentDao;
import by.htp.travelserviceWEB.dao.hotel.impl.ApartmentDaoImpl;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.service.hotel.ApartmentService;

public class ApartmentServiceImpl implements ApartmentService {
	
	private ApartmentDao apartmentDao;

	private ApartmentServiceImpl() {
		apartmentDao = ApartmentDaoImpl.getInstance();
	}

	private static class Singletone{
		private static final ApartmentServiceImpl INSTANCE = new ApartmentServiceImpl();
	}

	public static ApartmentServiceImpl getInstance() {
		return Singletone.INSTANCE;
	}

	@Override
	public List<Entity> fillingListByTheApartments(Entity entity) {
		return apartmentDao.fetchApartmentName(entity);
	}
}