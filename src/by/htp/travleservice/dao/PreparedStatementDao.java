package by.htp.travleservice.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class PreparedStatementDao {
	
	private PreparedStatement ps = null;
	
public PreparedStatement getPreparedStatement(String string, Connection conn) throws ClassNotFoundException {
		
		try {
			ps = conn.prepareStatement(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}

}
