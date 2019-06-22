package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Database.DatabaseLayer;
import model.User;

@Service
public class UserService 
{	
	DatabaseLayer databaseLayer = new DatabaseLayer();
	
	/**
	 * @brief Used to get All the User.
	 * @return Used to return the List.
	 */
	public List<User> getAllUserList()
	{
		List<User> userList =  new ArrayList<User>();
		userList = databaseLayer.getUserList();
		return userList;
	}
	
	/**
	 * @brief Used to pass the User to Database Layer.
	 * @param user to set
	 * @return User creation successful or not
	 */
	public boolean saveUser(User user)
	{
		boolean isUserCreated = databaseLayer.insertUserRecordIntoTable(user);
		return isUserCreated;
	}
	
	/**
	 * @brief: Used to update the user record
	 * @param id to set
	 * @param user to set
	 * @return User update successful or not.
	 */
	public boolean updateUserRecord(int id, User user)
	{
		boolean isUserUpdated = databaseLayer.updateUserRecord(id, user);
		return isUserUpdated;
	}
	
	/**
	 * @brief : Used to delete the user record
	 * @param id to set
	 * @return Used deleted or not.
	 */
	public boolean deleteUserById(int id)
	{
		boolean isUserDeleted = databaseLayer.deleteUserById(id);
		return isUserDeleted;
	}
	
}
