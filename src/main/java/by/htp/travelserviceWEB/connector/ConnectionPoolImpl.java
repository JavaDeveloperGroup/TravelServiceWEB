package by.htp.travelserviceWEB.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public final class ConnectionPoolImpl implements ConnectionProject {
	
	private ConcurrentHashMap<Connection, Boolean> connections;
	private int size = 5;
	private int numberOfConnection = 1;
	
	private ConnectionPoolImpl() {
		System.out.println(numberOfConnection);
	}
	
	{
		initConnectionPool();
	}
	
	private static class Singleton {
		private  static final ConnectionPoolImpl INSTANCE = new ConnectionPoolImpl();
	}
	
	public static ConnectionPoolImpl getInstance() {
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
		for (int i = connections.size(); i < size; i++) {
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
				numberOfConnection++;
				if (numberOfConnection == size) {
					size += 10;
					initConnectionPool();
				}
				connections.replace(iter.getKey(), true);
				return iter.getKey();
			}
			if (numberOfConnection == size) {
				size += 1;
				initConnectionPool();
			}
		}
		return null;
	}
	
	public final boolean getBack(Connection connection) {
		for (ConcurrentHashMap.Entry<Connection, Boolean> iter : connections.entrySet()) {
			if (iter.getKey() == connection) {
				connections.replace(iter.getKey(), false);
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

























