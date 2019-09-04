/**
 * 
 */
package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.User;
import util.Common_dbUtil;
import util.Constants;
import util.DataBaseUtil;
import util.Util_quary;


/**
 * @author thilini
 *
 */
public class UserManagement_implimentation implements UserManagementInterface {

	

		public static final Logger log = Logger.getLogger(UserManagement_implimentation.class.getName());


		private static Connection connection;

		
		private static Statement statement;

		
		

		static{
			
			createUserTable();
		}
		
		
	/* ************************************************************** */
		
		private PreparedStatement preparedStatement;
		
		
		
		public static void createUserTable() {

			try {
				connection = DataBaseUtil.getDBConnection();
				statement = connection.createStatement();
				statement.executeUpdate(Util_quary.queryByID(Constants.QUERY_ID_DROP_TABLE));
				statement.executeUpdate(Util_quary.queryByID(Constants.QUERY_ID_CREATE_TABLE));

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		
		
		
		/***********************************************************************************************/
		

		
		
		public void addUser(User User) {
			// TODO Auto-generated method stub
			
				String sl_no =Common_dbUtil.generateIDs(getsl_nos());
			
			
			try {
				connection = DataBaseUtil.getDBConnection();
			
				preparedStatement = connection
						.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_INSERT_Users));
				connection.setAutoCommit(false);
				
				User.setSl_no(sl_no );
		
				preparedStatement.setString(Constants.COLUMN_INDEX_ONE, User.getSl_no());
				preparedStatement.setString(Constants.COLUMN_INDEX_TWO, User.getUser_name());
				preparedStatement.setString(Constants.COLUMN_INDEX_THREE, User.getEmail());
				preparedStatement.setString(Constants.COLUMN_INDEX_FOUR, User.getMobile());
				preparedStatement.setString(Constants.COLUMN_INDEX_FIVE, User.getAddress());
				preparedStatement.setString(Constants.COLUMN_INDEX_SIX, User.getMemberType());
				preparedStatement.setString(Constants.COLUMN_INDEX_SEVEN, User.getGender());
				
			
				preparedStatement.execute();
				connection.commit();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {


				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			
		}

		
		
		
		
		
		
	
		public User getUserByID(String sl_no) {
			
			return actionOnUser(sl_no ).get(0);
		}

		
		public ArrayList<User> getUsers() {
			
			return actionOnUser(null);
		}

		
		/*****************************************************************/	
		@Override
		public User updateUser(String sl_no , User User) {
			// TODO Auto-generated method stub
			
			if (sl_no  != null && !sl_no .isEmpty()) {


				
				try {
					connection = DataBaseUtil.getDBConnection();
					preparedStatement = connection.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_UPDATE_User));
					preparedStatement.setString(Constants.COLUMN_INDEX_ONE, User.getUser_name());
					preparedStatement.setString(Constants.COLUMN_INDEX_TWO, User.getEmail());
					preparedStatement.setString(Constants.COLUMN_INDEX_THREE, User.getMobile());
					preparedStatement.setString(Constants.COLUMN_INDEX_FOUR, User.getAddress());
					preparedStatement.setString(Constants.COLUMN_INDEX_FIVE, User.getMemberType());
					preparedStatement.setString(Constants.COLUMN_INDEX_SIX, User.getGender());
					preparedStatement.setString(Constants.COLUMN_INDEX_SEVEN, User.getSl_no());
					preparedStatement.executeUpdate();

				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {


					
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
			// Get the updated sl_no 
			return getUserByID(sl_no );
		}

		
		
		
		/*****************************************************************/
		
		
		@Override
		public void removeUsers(String sl_no ) {
			// TODO Auto-generated method stub
		
			
			if (sl_no  != null && !sl_no .isEmpty()) {


				
				try {
					connection = DataBaseUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_REMOVE_Users ));
					preparedStatement.setString(Constants.COLUMN_INDEX_ONE, sl_no );
					preparedStatement.executeUpdate();
				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {


					
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
			
			
		}

		
		/****************************************************************/
		
		private ArrayList<User>actionOnUser(String sl_no) {

			ArrayList<User>UserList = new ArrayList<User>();
			try {
				connection = DataBaseUtil.getDBConnection();
				
				
				
				if (sl_no  != null && !sl_no .isEmpty()) {


					
					
					preparedStatement = connection
							.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_GET_Users));
					preparedStatement.setString(Constants.COLUMN_INDEX_ONE, sl_no);
				}
				
				else {
					preparedStatement = connection
							.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_ALL_Users));
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				
				while (resultSet.next()) {
					User User = new User();
					
					User.setSl_no(resultSet.getString(Constants.COLUMN_INDEX_ONE));
					User.setUser_name(resultSet.getString(Constants.COLUMN_INDEX_TWO));
					User.setEmail(resultSet.getString(Constants.COLUMN_INDEX_THREE));
					User.setMobile(resultSet.getString(Constants.COLUMN_INDEX_FOUR));
					User.setAddress(resultSet.getString(Constants.COLUMN_INDEX_FIVE));
					User.setMemberType(resultSet.getString(Constants.COLUMN_INDEX_SIX));
					User.setGender(resultSet.getString(Constants.COLUMN_INDEX_SEVEN));
					UserList.add(User);
				}

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {


				
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return UserList;
		}
		
		
		

		
		/*********************************************************/
		
		
		private ArrayList<String>getsl_nos(){
			
			ArrayList<String> arrayList = new ArrayList<String>();


			
			try {
				connection = DataBaseUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(Util_quary.queryByID(Constants.QUERY_ID_GET_User_IDS));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					arrayList.add(resultSet.getString(Constants.COLUMN_INDEX_ONE));
				}
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {


				
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return arrayList;
		}
		
		
		
		
	}

	
	

