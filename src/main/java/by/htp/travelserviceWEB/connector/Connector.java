package by.htp.travelserviceWEB.connector;

import java.sql.Connection;

public class Connector {
	
	private int x;

	private Connector() {}
	
	private static class Singleton {
		private static final Connector INSTANCE = new Connector();
	}
	
	public static Connector getInstance() {
		return Singleton.INSTANCE;
	}
	
	public Connection getConnection() {
		try {
			x = 1;
			return OwnConnection.getInstance().getConnection();
		}catch (Exception e) {
			x = 0;
			
			return ApacheConnector.getInstance().getConnection();
		}
	}
	
	public void getBack(Connection conn) {
		if(x == 0) {
			OwnConnection.getInstance().getBack(conn);
		}
	}

}
