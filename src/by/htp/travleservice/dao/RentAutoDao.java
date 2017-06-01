package by.htp.travleservice.dao;

import java.util.List;
import by.htp.travleservice.entity.RentAuto;

public interface RentAutoDao {
	
	List<RentAuto> fetchRentAuto(String string);

}