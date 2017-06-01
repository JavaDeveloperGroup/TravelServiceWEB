package by.htp.travleservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import by.htp.travleservice.connection.MySQLConnector;
import by.htp.travleservice.entity.Apartment;
import by.htp.travleservice.entity.Auto;
import by.htp.travleservice.entity.RentAuto;
import by.htp.travleservice.entity.Salon;

public class RentAutoDaoImpl extends PreparedStatementDao implements RentAutoDao {

	@Override
	public List<RentAuto> fetchRentAuto(String string) {
		
		PreparedStatement ps = null;
		List<RentAuto> rentAuto = new ArrayList<RentAuto>();
		Auto auto = null;
		Salon salon = null;
		Connection conn = null;
		
		try {
			ps = super.getPreparedStatement(string, conn);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int rentAutoId = rs.getInt(1);
				double price = rs.getDouble(2);
				String status = rs.getString(3);
				//String image = rs.getString(4);
				
				rentAuto.add(new RentAuto(rentAutoId, auto, salon, status, price));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rentAuto;
	}	
	
}