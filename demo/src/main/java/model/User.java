package model;

///*{
//	"firstName" : "ankit",
//	"lastName" : "negi",
//	"userName" :"ankitshriwal",
//	"email" : "ankit.shriwal@gmail.com"
//}*/

public class User 
{
	String firstName;
	String lastName;
	String userName;
	String email;
	
	public User(String firstName, String lastName, String userName, String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
	}
	
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
