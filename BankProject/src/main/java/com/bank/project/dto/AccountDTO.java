package com.bank.project.dto;

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
public class AccountDTO {

	private int accountId;

	private String accountNo;

	private int userId;

	private int balance;

	private String openingDate;

}
