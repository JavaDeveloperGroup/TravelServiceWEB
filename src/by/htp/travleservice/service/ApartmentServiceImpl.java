package by.htp.travleservice.service;

import java.util.List;

import by.htp.travleservice.dao.ApartmentDao;
import by.htp.travleservice.dao.ApartmentDaoImpl;
import by.htp.travleservice.entity.Apartment;

import static by.htp.travleservice.util.ConstantValue.*;

public class ApartmentServiceImpl implements ApartmentService {
	
	private ApartmentDaoImpl dao;
	
	public ApartmentServiceImpl() {
		dao = new ApartmentDaoImpl();
	}

	@Override
	public List<Apartment> list() {
		List<Apartment> apartment = null;
		apartment = dao.fetchApartment(SQL_STATEMENT_SELECT_ALL_APARTMENT);
		return apartment;
	}
}