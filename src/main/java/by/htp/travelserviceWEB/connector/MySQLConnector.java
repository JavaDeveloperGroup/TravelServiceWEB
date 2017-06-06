package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConnector {
	
	private static final String DATASOURCE_NAME = "travelservice";
	private static DataSource ds = null;
	
	private MySQLConnector(){}
	
	private static class Singleton {
		private static final MySQLConnector INSTANCE = new MySQLConnector();
	}
	
	public static MySQLConnector getInstance() {
		return Singleton.INSTANCE;
	}
	
	{
		try {
			
			Context initContext = new InitialContext();
			Context dataContext = (Context) initContext.lookup("java:jdbc/travelservice");
			ds = (DataSource) dataContext.lookup(DATASOURCE_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection conn() {
		
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Connection conn = null;
		InitialContext initContext = null;
		DataSource ds = null;
		
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("");
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}	*/	

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
