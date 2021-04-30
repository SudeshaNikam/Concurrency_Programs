package com.bank.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "ACCOUNT")
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Account {

	@Id
	@Column(name = "ID", length = 64, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@Column(name = "ACCOUNT_NO", length = 64)
	private String accountNo;

	@Column(name = "USER_ID", length = 64)
	private int userId;

	@Column(name = "BALANCE", length = 64)
	private int balance;

	@Column(name = "Date")
	private String openingDate;

}
