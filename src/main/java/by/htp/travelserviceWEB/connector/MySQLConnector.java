package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConnector {
	
	private MySQLConnector(){}
	
	private static class Singleton {
		private static final MySQLConnector INSTANCE = new MySQLConnector();
	}
	
	public static MySQLConnector getInstance() {
		return Singleton.INSTANCE;
	}
	public Connection conn() {
		
		Connection conn = null;
		InitialContext initContext = null;
		DataSource ds = null;
		
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:jdbc/appname");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}		

		return conn;
	}
	public PreparedStatement prepareStatement(String string, Connection conn) throws ClassNotFoundException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ps;
	}
}
