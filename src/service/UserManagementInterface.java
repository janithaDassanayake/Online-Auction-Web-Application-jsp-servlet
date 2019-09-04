/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.User;

/**
 * @author thilini
 *
 */
public interface UserManagementInterface {

	
		public static final Logger log = Logger.getLogger(UserManagementInterface.class.getName());


		public void addUser(User User);

	
		public User getUserByID(String sl_no);
		
		
		public ArrayList<User> getUsers();
		
		
		public User updateUser(String sl_no , User User);

		
		public void removeUsers(String sl_no);

	
}
