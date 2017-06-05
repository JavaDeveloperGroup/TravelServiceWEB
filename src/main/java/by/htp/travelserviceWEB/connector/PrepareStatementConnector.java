package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementConnector {

	public static PreparedStatement prepareStatement(String string, Connection conn) throws ClassNotFoundException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ps;
	}

}
