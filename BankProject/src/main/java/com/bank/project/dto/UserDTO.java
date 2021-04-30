package com.bank.project.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SUDESHA
 *
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private int userId;

	@NotEmpty(message = "userName is mandatory")
	private String userName;

	@NotEmpty(message = "password is mandatory")
	@Size(min = 3, max = 64, message = "Your password must between 3 and 64 characters")
	private String password;

	@Email
	@NotEmpty(message = "mail is mandatory")
	private String emailId;

	private String phoneNo;

}
