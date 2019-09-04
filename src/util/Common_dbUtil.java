/**
 * 
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.UserManagementInterface;

/**
 * @author thilini
 *
 */
public class Common_dbUtil {
	
	

	public static final Logger log = Logger.getLogger(UserManagementInterface.class.getName());

	public static final Properties properties = new Properties();

	
	
	
	static {
		try {
			
			// Read the property only once when load the class
			properties.load(Util_quary.class.getResourceAsStream(Constants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	//Add new User ID
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = Constants.User_ID_PREFIX  + next;
		if (arrayList.contains(id)) {
			next++;
			id = Constants.User_ID_PREFIX  + next;
		}
		return id;
	}
}

	
	


