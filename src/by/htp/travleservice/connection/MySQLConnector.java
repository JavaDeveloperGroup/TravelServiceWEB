

package by.htp.travleservice.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class MySQLConnector {
	
	private static Connection conn() throws ClassNotFoundException, SQLException {
		
		/*ResourceBundle rb = ResourceBundle.getBundle(PARAM_DATABASE_CONFIG);
		String dbUrl = rb.getString(PARAM_DATABASE_URL);
		String dbLogin = rb.getString(PARAM_DATABASE_LOGIN);
		String dbPass = rb.getString(PARAM_DATABASE_PASS);
		String dbDriverName = rb.getString(PARAM_DATABASE_DRIVER_NAME);*/

		Connection conn = null;
		InitialContext initContext = null;
		DataSource ds = null;
		
		try {
			initContext = new InitialContext();
			ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		conn = ds.getConnection();
		
		//conn.close();
		
		/*Connection conn = null;
		Class.forName(dbDriverName);
		conn = DriverManager.getConnection(dbUrl, dbLogin, dbPass);*/
		
		return conn;
	}

}
