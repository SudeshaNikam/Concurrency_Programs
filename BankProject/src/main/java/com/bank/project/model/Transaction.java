/**
 * 
 */
package com.bank.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SUDESHA
 *
 */
@Entity
@Table(name = "TRANSCTION")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Transaction {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@NotEmpty(message = "accountNumber is mandatory")
	@Column(name = "FROM_ACCOUNT_NO", length = 64, nullable = false)
	private String fromAccountNumber;

	@NotEmpty(message = "accountNumber is mandatory")
	@Column(name = "TO_ACCOUNT_NO", length = 64, nullable = false)
	private String toAccountNumber;

	@Column(name = "AMOUNT", length = 64)
	private int amount;

	@Column(name = "DATE", length = 64)
	private String date;

	@Column(name = "DESCRIPTION", length = 64)
	private String description;

	@Column(name = "USER_ID", length = 64)
	private int userId;

}
