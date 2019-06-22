package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import model.User;
import service.UserService;

@RestController
@RequestMapping("/endpoint")
public class UserController {

	@Autowired
	UserService userService;	//Service which will do all data retrieval/manipulation work

	/**
	 * @brief : Used to get a list of all User
	 * @return userList
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listAllUsers() 
	{
		List<User> userList = userService.getAllUserList();
		return userList;
	}

	/**
	 * @brief: Used to create the User
	 * @param user to set
	 * @return User Saved or not. 
	 */
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public boolean createUser(@RequestBody User user) 
	{
		userService.saveUser(user);
		return true;
	}
	
	/**
	 * @brief : Used to set the 
	 * @param id to set
	 * @param user to set
	 * @return Update user value successful or not.
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public boolean updateUser(@PathVariable("id") int id, @RequestBody User user) 
	{
		userService.updateUserRecord(id, user);
        return true;
    }
	
	/**
	 * @brief : Used to delete the User
	 * @param id to set.
	 * @return User deleted successful or not.
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable("id") int id) 
	{
         userService.deleteUserById(id);
        return true;
    }

}
