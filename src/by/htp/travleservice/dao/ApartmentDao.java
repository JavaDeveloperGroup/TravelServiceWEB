package by.htp.travleservice.dao;

import java.util.List;

import by.htp.travleservice.entity.Apartment;

public interface ApartmentDao {
	
	List<Apartment> fetchApartment(String string);
	
}