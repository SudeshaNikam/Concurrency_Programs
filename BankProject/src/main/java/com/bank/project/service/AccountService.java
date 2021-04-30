/**
 * 
 */
package com.bank.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.project.dto.AccountDTO;
import com.bank.project.model.Account;

/**
 * @author SUDESHA
 *
 */
@Service
public interface AccountService {

	/**
	 * @param accountDTO
	 * @param userId
	 */
	void saveAccountDetails(AccountDTO accountDTO, int userId);

	/**
	 * @param userId
	 * @return
	 */
	List<AccountDTO> getAllAccountDetailsById(int userId);

	/**
	 * @return
	 */
	List<Account> getAllAccountDetails();

	/**
	 * @param fromAccountNumber
	 * @return
	 */
	Account geAccountIdByFromAccNo(String fromAccountNumber);

	

}
