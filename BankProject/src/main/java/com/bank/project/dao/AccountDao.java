/**
 * 
 */
package com.bank.project.dao;

import java.util.List;

import com.bank.project.model.Account;

/**
 * @author SUDESHA
 *
 */

public interface AccountDao {

	void saveAccountDetails(Account account);

	List<Account> getAllAccountDetails();

	List<Account> getAllAccountDetailsById(int userId);

	/**
	 * @param fromAccountNumber
	 * @return
	 */
	Account geAccountIdByFromAccNo(String fromAccountNumber);

	/**
	 * @param toAccountNumber
	 * @return
	 */
	Account geAccountIdByToAccNo(String toAccountNumber);

}
