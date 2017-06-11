package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConnector {

	private static final String DATASOURCE_NAME = "java:/comp/env/jdbc/travelservice";

	private MySQLConnector() {
	}

	private static class Singleton {
		private static final MySQLConnector INSTANCE = new MySQLConnector();
	}

	public static MySQLConnector getInstance() {
		return Singleton.INSTANCE;
	}

	public Connection conn() {

		Connection conn = null;
		DataSource ds = null;
		try {
			InitialContext ic   = new InitialContext();
            ds = (DataSource)ic.lookup(DATASOURCE_NAME);
			conn = ds.getConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
