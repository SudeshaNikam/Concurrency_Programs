/**
 * 
 */
package com.bank.project.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.dto.TransactionDTO;
import com.bank.project.model.Transaction;

/**
 * @author SUDESHA
 *
 */
@Component
public class TransactionConverter {

	/**
	 * @param transactionDTO
	 * @return transaction
	 */
	public Transaction convertDtoToEntity(TransactionDTO transactionDTO) {

		Transaction tran = new Transaction();
		tran.setAmount(transactionDTO.getAmount());
		tran.setDate(transactionDTO.getDate());
		tran.setDescription(transactionDTO.getDescription());
		tran.setFromAccountNumber(transactionDTO.getFromAccountNumber());
		tran.setToAccountNumber(transactionDTO.getToAccountNumber());
		tran.setTransactionId(transactionDTO.getTransactionId());
		tran.setUserId(transactionDTO.getUserId());
		return tran;
	}

	/**
	 * @param transaction
	 * @return List<TransactionDTO>
	 */
	public List<TransactionDTO> convertEntityToDto(List<Transaction> transaction) {
		List<TransactionDTO> transactionDTO = new ArrayList<TransactionDTO>();
		for (Transaction tran : transaction) {
			TransactionDTO trandto = new TransactionDTO();
			trandto.setAmount(tran.getAmount());
			trandto.setDate(tran.getDate());
			trandto.setDescription(tran.getDescription());
			trandto.setFromAccountNumber(tran.getFromAccountNumber());
			trandto.setToAccountNumber(tran.getToAccountNumber());
			trandto.setTransactionId(tran.getTransactionId());
			trandto.setUserId(tran.getUserId());
			transactionDTO.add(trandto);
		}
		return transactionDTO;
	}
}
