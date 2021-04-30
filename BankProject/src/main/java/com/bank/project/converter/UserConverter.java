/**
 * 
 */
package com.bank.project.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.dto.UserDTO;
import com.bank.project.model.User;

/**
 * @author SUDESHA
 *
 */
@Component
public class UserConverter {

	/**
	 * @param UserDTO
	 * @return User
	 */
	public User convertDtoToEntity(UserDTO userDTO) {
		User user = new User();

		user.setUserId(userDTO.getUserId());
		user.setEmailId(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserName(userDTO.getUserName());

		return user;

	}

	/**
	 * @param User
	 * @return List<UserDTO> >
	 */
	public List<UserDTO> convertEntityToDto(List<User> user) {
		List<UserDTO> userdto = new ArrayList<UserDTO>();
		for (User user1 : user) {
			UserDTO udto = new UserDTO();
			udto.setUserId(user1.getUserId());
			udto.setEmailId(user1.getEmailId());
			udto.setPassword(user1.getPassword());
			udto.setPhoneNo(user1.getPhoneNo());
			udto.setUserName(user1.getUserName());
			userdto.add(udto);
		}
		return userdto;
	}
}
