package by.htp.travleservice.service;

import static by.htp.travleservice.util.ConstantValue.*;

import java.util.List;

import by.htp.travleservice.dao.RentAutoDaoImpl;
import by.htp.travleservice.entity.RentAuto;

public class RentAutoServiceImpl implements RentAutoService {
	
	private RentAutoDaoImpl dao;
	
	public RentAutoServiceImpl() {
		dao = new RentAutoDaoImpl();
	}	

	@Override
	public List<RentAuto> list() {
		List<RentAuto> rentAuto = null;
		rentAuto = dao.fetchRentAuto(SQL_STATEMENT_SELECT_ALL_RENT_AUTO);
		return rentAuto;
	}
	
	

}