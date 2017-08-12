package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPool {
	
	private ConcurrentHashMap<Connection, Boolean> connections;
	private int size;
	private int numberOfConnection;
	
	private ConnectionPool() {
		this.size = 1;
		this.numberOfConnection = 0;
		initConnectionPool();
	}
	
	private static class Singleton {
		private  static final ConnectionPool INSTANCE = new ConnectionPool();
	}
	
	public static ConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}
	public void initConnectionPool() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String url = rb.getString("db.url");
		String user = rb.getString("db.login");
		String password = rb.getString("db.pass");
		String driver = rb.getString("db.driver.name");
		
		connections = new ConcurrentHashMap<Connection, Boolean>();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = connections.size(); i < this.size; i++) {
			try {
				connections.put(DriverManager.getConnection(url, user, password), false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public final Connection getConnection() {		
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (!iter.getValue()) {
				connections.replace(iter.getKey(), true);
				numberOfConnection++;
				return iter.getKey();
			} else if (numberOfConnection == size) {
				size += 1;
				initConnectionPool();
				getConnection();
			}
		}
		return null;
	}
	
	public final boolean putBack(Connection connection) {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (iter.getKey() == connection) {
				connections.replace(iter.getKey(), false);
				numberOfConnection--;
				return true;
			}
		}
		return false;
	}
	
	public final boolean close() {
		boolean error = false;
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			try {
				iter.getKey().close();
			} catch (SQLException e) {
				error = true;
			}
		}
		return !error;
	}
}