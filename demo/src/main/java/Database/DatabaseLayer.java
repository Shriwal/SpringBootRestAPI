package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DatabaseLayer {
	
	/**
	 * @brief Used to create User table in the Database.
	 */
	public void createTableUser() 
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String createTableUser = "CREATE TABLE IF NOT EXISTS USER"
				  + "(userID INTEGER PRIMARY KEY AUTOINCREMENT,"  
				  + "firstName TEXT not null,"  
				  + "lastName text not null,"  
				  + "userName TEXT not null,"  
				  + "email TEXT not null)";
		
		try {
			
			dbConnection = getConnection();
			preparedStatement = dbConnection.prepareStatement(createTableUser);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @brief Used to insert the record in the USER.
	 * @param veranstaltungseintrag Used to pass all the User parameter.
	 */
	public boolean insertUserRecordIntoTable(User user) 
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertQueryUserRecordIntoUserTable = "INSERT INTO USER"
												  + "(firstName, lastName, userName, email) VALUES"
												  + "(?,?,?,?)";

		try {
			dbConnection = getConnection();
			preparedStatement = dbConnection.prepareStatement(insertQueryUserRecordIntoUserTable);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getEmail());

			preparedStatement.executeUpdate();
			preparedStatement.close();


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	/**
	 * @brief Used to get the User list.
	 * @return User list.
	 */
	public List<User> getUserList() 
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectVeranstaltungUbungConflictSQL = "SELECT * FROM USER";
		
		List<User> userList = new ArrayList<>();

		try {
			dbConnection = getConnection();

			preparedStatement = dbConnection.prepareStatement(selectVeranstaltungUbungConflictSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) 
			{
				String firstName = rs.getString("firstName"); 
				String lastName = rs.getString("lastName"); 
				String userName = rs.getString("userName");
				String email = rs.getString("email");
				
				User user = new User(firstName, lastName, userName, email);

				userList.add(user);
			}

			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}
	
	/**
	 * @brief: Used to update the User result in database.
	 * @param id to set
	 * @param user value to set
	 * @return updating user successful or not.
	 */
	public boolean updateUserRecord(int id, User user) 
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String updateQueryRecordUser = "UPDATE USER "
				+ "SET firstName = ?, "
				+ "lastName = ?, "
				+ "userName =  ?,"
				+ "email =  ?"
				+ "WHERE userID = ?";

		dbConnection = getConnection();
		try
		{
			preparedStatement = dbConnection.prepareStatement(updateQueryRecordUser);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, id);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	/**
	 * @brief: Used to delete the particular user
	 * @param id to set
	 * @return deletion of user successful or not
	 */
	public boolean deleteUserById(int id)  
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteTablePflichtSQL = "DELETE from USER where userID = ?";

		try {
			dbConnection = getConnection();
			preparedStatement = dbConnection.prepareStatement(deleteTablePflichtSQL);
			
			preparedStatement.setInt(1, id);
			
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	/**
	 * @brief : Used to create Database Connection.
	 * @return : return the connection.
	 */
	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:STULP.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return connection;
	}
}
