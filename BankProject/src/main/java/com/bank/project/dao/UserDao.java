/**
 * 
 */
package com.bank.project.dao;

import java.util.List;

import com.bank.project.model.User;

/**
 * @author SUDESHA
 *
 */

public interface UserDao {

	void saveUserDetails(User user);

	void updateUserDetails(User user);

	List<User> getAllUserDetails();

	List<User> getUpdateDetails(int userId);

	String loginCheck(String userName, String password);

	int getUserId(String userName);

}
