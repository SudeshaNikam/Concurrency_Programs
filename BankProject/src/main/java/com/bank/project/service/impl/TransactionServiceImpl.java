/**
 * 
 */
package com.bank.project.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.project.converter.TransactionConverter;
import com.bank.project.dao.AccountDao;
import com.bank.project.dao.TransactionDao;
import com.bank.project.dto.TransactionDTO;
import com.bank.project.model.Account;
import com.bank.project.model.Transaction;
import com.bank.project.service.TransactionService;

/**
 * @author SUDESHA
 *
 */

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	AccountDao accountDao;

	@Autowired
	TransactionConverter transactionConverter;

	@Override
	@Transactional
	public void saveTransferAmount(TransactionDTO transactionDTO, int userId) {
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDate);

		LocalTime localTime = LocalTime.now();
		String time = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(localTime);

		// withdraw amount

		Account accountId1 = accountDao.geAccountIdByFromAccNo(transactionDTO.getFromAccountNumber());
		int amount1 = accountId1.getBalance() - transactionDTO.getAmount();
		transactionDao.removeAndAmount(accountId1.getAccountId(), amount1);

		// transfer amount
		Account accountId2 = accountDao.geAccountIdByToAccNo(transactionDTO.getToAccountNumber());
		int amount2 = accountId2.getBalance() + transactionDTO.getAmount();
		transactionDao.removeAndAmount(accountId2.getAccountId(), amount2);

		transactionDTO.setUserId(userId);
		transactionDTO.setDate(date + " " + time);

		Transaction transs = transactionConverter.convertDtoToEntity(transactionDTO);
		transactionDao.saveTransferAmount(transs, userId);

	}

	@Override
	public List<TransactionDTO> getTransactionHistory(int userId) {
		List<Transaction> trans = transactionDao.getTransactionHistory(userId);
		List<TransactionDTO> transactionDTOs =transactionConverter.convertEntityToDto(trans);
		return transactionDTOs;
	}

}
