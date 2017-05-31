package by.htp.travleservice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static by.htp.travleservice.util.ConstantValue.*;

public final class MySQLConnector {
	public static Connection establishingConnection() {
		ResourceBundle rb = ResourceBundle.getBundle(PARAM_DATABASE_CONFIG);
		String dbUrl = rb.getString(PARAM_DATABASE_URL);
		String dbLogin = rb.getString(PARAM_DATABASE_LOGIN);
		String dbPass = rb.getString(PARAM_DATABASE_PASS);
		String dbDriverName = rb.getString(PARAM_DATABASE_DRIVER_NAME);

		Connection conn = null;

		try {
			Class.forName(dbDriverName);
			conn = DriverManager.getConnection(dbUrl, dbLogin, dbPass);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/*public static PreparedStatement prepareStatement(String string) {
		PreparedStatement ps = null;
		try {
			ps = establishingConnection().prepareStatement(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}*/
}
