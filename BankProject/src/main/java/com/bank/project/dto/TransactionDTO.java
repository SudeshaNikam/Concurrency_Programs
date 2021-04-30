/**
 * 
 */
package com.bank.project.dto;

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
public class TransactionDTO {
	private int transactionId;

	@NotEmpty(message = "accountNumber is mandatory")
	private String fromAccountNumber;

	@NotEmpty(message = "accountNumber is mandatory")
	private String toAccountNumber;

	private int amount;

	private String date;

	private String description;

	private int userId;

}
