package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ApacheConnector implements ConnectionFetch{

	private static final String DATASOURCE_NAME = "java:/comp/env/jdbc/travelservice";

	private ApacheConnector() {}

	private static class Singleton {
		private static final ApacheConnector INSTANCE = new ApacheConnector();
	}

	public static ApacheConnector getInstance() {
		return Singleton.INSTANCE;
	}

	public Connection getConnection() {

		Connection connection = null;
		DataSource ds = null;
		try {
			InitialContext ic   = new InitialContext();
            ds = (DataSource)ic.lookup(DATASOURCE_NAME);
			connection = ds.getConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
