package by.htp.travleservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Connector;

import by.htp.travleservice.connection.MySQLConnector;
import by.htp.travleservice.entity.Apartment;
import by.htp.travleservice.entity.Hotel;
import by.htp.travleservice.entity.Room;

public class ApartmentDaoImpl extends PreparedStatementDao implements ApartmentDao {
	
	@Override
	public List<Apartment> fetchApartment(String string) {

		PreparedStatement ps = null;
		List<Apartment> apartment = new ArrayList<Apartment>();
		Hotel hotel = null;
		Room room = null;
		Connection conn = null;
		
		try {
			ps = super.getPreparedStatement(string, conn);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Integer apartmentId = rs.getInt(1);
				Double price = rs.getDouble(2);
				String status = rs.getString(3);
				String image = rs.getString(4);
				
				apartment.add(new Apartment(apartmentId, hotel, room, price, status, image));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return apartment;
	}
	
	
}