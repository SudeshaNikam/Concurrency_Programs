/**
 * 
 */
package com.bank.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.project.converter.UserConverter;
import com.bank.project.dao.UserDao;
import com.bank.project.dto.UserDTO;
import com.bank.project.model.User;
import com.bank.project.service.UserService;

/**
 * @author SUDESHA
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDto;

	@Autowired
	UserConverter userConverter;

	@Override
	@Transactional
	public void saveUserDetails(UserDTO userDTO) {

		User user = userConverter.convertDtoToEntity(userDTO);
		userDto.saveUserDetails(user);
	}

	@Override
	@Transactional
	public void updateUserDetails(UserDTO userDTO) {
		User user = userConverter.convertDtoToEntity(userDTO);
		userDto.updateUserDetails(user);

	}

	@Override
	public List<UserDTO> getAllUserDetails() {
		List<User> user = userDto.getAllUserDetails();
		List<UserDTO> userDTOs = userConverter.convertEntityToDto(user);

		return userDTOs;
	}

	@Override
	public String loginCheck(String userName, String password) {
		return userDto.loginCheck(userName, password);
	}

	@Override
	public List<UserDTO> getUpdateDetails(int userId) {
		List<User> user = userDto.getUpdateDetails(userId);
		List<UserDTO> userDTOs = userConverter.convertEntityToDto(user);

		return userDTOs;
	}

	@Override
	public int getUserId(String userName) {
		return userDto.getUserId(userName);
	}

}
