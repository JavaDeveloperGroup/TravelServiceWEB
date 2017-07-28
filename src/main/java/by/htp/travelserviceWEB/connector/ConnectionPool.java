package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPool {
	
	private ConcurrentHashMap<Connection, Boolean> connections;
	private int size;
	private int connectionCount;
	
	private ConnectionPool() {
		this.size = 10;
		connections = new ConcurrentHashMap<Connection, Boolean>();
		initConnectionPool();
	}
	
	private static class Singleton {
		private  static final ConnectionPool INSTANCE = new ConnectionPool();
	}
	
	public static ConnectionPool getInstance() {
		return Singleton.INSTANCE;
	}
	
	public void initConnectionPool() {
		for (int i = connections.size(); i < this.size; i++) {
			try {
				connections.put(DriverManager.getConnection(values().get(0), values().get(1), 
															values().get(2)), false);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public final Connection getConnection() {
		for (ConcurrentHashMap.Entry<Connection, Boolean> connection : connections.entrySet()) {
			if (!connection.getValue()) {
				connections.replace(connection.getKey(), true);
				connectionCount = 1;
				for (ConcurrentHashMap.Entry<Connection, Boolean> connCheck : connections.entrySet()) {
					if (connCheck.getValue()) {
						connectionCount++;
					}
				}
				return connection.getKey();
			} else {
				if (connectionCount == size) {
					size += 10;
					initConnectionPool();
				}
			}
		}
		return reserveConnection();
	}
	
	public final boolean putBack(Connection connection) {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (iter.getKey() == connection) {
				connections.replace(iter.getKey(), false);
				return true;
			}
		}
		return false;
	}
	//need to write a logger to display has not closed the connection.
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
	
	private List<String> values() {
		List<String> resourseBundleList = new ArrayList<>();
		
		ResourceBundle rb = ResourceBundle.getBundle("config");
		resourseBundleList.add(rb.getString("db.url"));
		resourseBundleList.add(rb.getString("db.login"));
		resourseBundleList.add(rb.getString("db.pass"));
		String driver = rb.getString("db.driver.name");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resourseBundleList;
	}
	
	private Connection reserveConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(values().get(0), 
									values().get(1), values().get(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}