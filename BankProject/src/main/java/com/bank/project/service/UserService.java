/**
 * 
 */
package com.bank.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.project.dto.UserDTO;

/**
 * @author SUDESHA
 *
 */
@Service
public interface UserService {

	/**
	 * @return
	 */
	List<UserDTO> getAllUserDetails();

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	String loginCheck(String userName, String password);

	/**
	 * @param userName
	 * @return
	 */
	int getUserId(String userName);

	/**
	 * @param userDTO
	 */
	void saveUserDetails(UserDTO userDTO);

	/**
	 * @param userDTO
	 */
	void updateUserDetails(UserDTO userDTO);

	/**
	 * @param userId
	 * @return
	 */
	List<UserDTO> getUpdateDetails(int userId);

}
