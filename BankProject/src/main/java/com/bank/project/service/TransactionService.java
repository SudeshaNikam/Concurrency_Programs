/**
 * 
 */
package com.bank.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.project.dto.TransactionDTO;

/**
 * @author SUDESHA
 *
 */
@Service
public interface TransactionService {

	/**
	 * @param account
	 * @param userId
	 * @param model
	 * @param model
	 */
	void saveTransferAmount(TransactionDTO transactionDTO, int userId);

	/**
	 * @param userId
	 * @return
	 */
	List<TransactionDTO> getTransactionHistory(int userId);

}
