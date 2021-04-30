/**
 * 
 */
package com.bank.project.dao;

import java.util.List;

import com.bank.project.model.Transaction;

/**
 * @author SUDESHA
 *
 */

public interface TransactionDao {

	/**
	 * @param transaction
	 * @param userId
	 */
	void saveTransferAmount(Transaction transaction, int userId);

	/**
	 * @param userId
	 * @return
	 */
	List<Transaction> getTransactionHistory(int userId);

	/**
	 * @param accountId
	 * @param amount1
	 */
	void removeAndAmount(int accountId, int amount1);

}
