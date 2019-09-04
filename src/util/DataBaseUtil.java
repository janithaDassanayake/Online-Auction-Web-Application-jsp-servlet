/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author janith
 *
 */
public class DataBaseUtil extends Common_dbUtil {
	
	

	private static Connection connection;
	
	 public DataBaseUtil() {
		// TODO Auto-generated constructor stub
	}
	 
	 {
		
		// singleton pattern applied
		
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is null
		 */
		if (connection == null || connection.isClosed()) {

			Class.forName(properties.getProperty(Constants.DRIVER));
			
			connection = DriverManager.getConnection(properties.getProperty(Constants.URL),
					
					properties.getProperty(Constants.USERNAME), properties.getProperty(Constants.PASSWORD));
		}
		
		return connection;
	}

}
