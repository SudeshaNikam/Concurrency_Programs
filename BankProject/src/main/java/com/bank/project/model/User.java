package com.bank.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SUDESHA
 *
 */

@Entity
@Table(name = "USER")
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
	@Id
	@Column(name = "ID", length = 64, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotEmpty(message = "userName is mandatory")
	@Column(name = "USER_NAME", length = 64, nullable = false)
	private String userName;

	@NotEmpty(message = "password is mandatory")
	@Size(min = 3, max = 64, message = "Your password must between 3 and 64 characters")
	@Column(name = "PASSWORD", length = 64, nullable = false)
	private String password;

	@Email
	@NotEmpty(message = "mail is mandatory")
	@Column(name = "EMAIL_ID", length = 64)
	private String emailId;

	@Column(name = "PHONE_NO", length = 64)
	private String phoneNo;

}
