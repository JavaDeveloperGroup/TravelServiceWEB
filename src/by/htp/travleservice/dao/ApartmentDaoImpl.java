package by.htp.travleservice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.travleservice.connection.MySQLConnector;
import by.htp.travleservice.entity.Apartment;

public class ApartmentDaoImpl implements ApartmentDao {

	/*@Override
	public Object select(Object obj, String string) {
		PreparedStatement ps = null;
		
		if (obj instanceof Apartment) {
			obj = new Apartment();
				try {
					ps = MySQLConnector.establishingConnection().prepareStatement(string);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {						
						((Apartment) obj).setApartmentId(rs.getInt(1));
						((Apartment) obj).setPrice(rs.getDouble(2));
						((Apartment) obj).setStatus(rs.getString(3));
						((Apartment) obj).setImage(rs.getString(4));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return obj;
	}*/
	
	public Object select(Apartment apartment, String string) {
		synchronized (this) {
					PreparedStatement ps = null;
					apartment = new Apartment();
				try {
					ps = MySQLConnector.establishingConnection().prepareStatement(string);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {						
						apartment.setApartmentId(rs.getInt(1));
						apartment.setPrice(rs.getDouble(2));
						apartment.setStatus(rs.getString(3));
						apartment.setImage(rs.getString(4));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println();
		}

		return apartment;
	}

	public boolean insertInto() {
		
		return false;
	}

	public boolean update() {
		
		return false;
	}

	public boolean delete() {
		
		return false;
	}

}