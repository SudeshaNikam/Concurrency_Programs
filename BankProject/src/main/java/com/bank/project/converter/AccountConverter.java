/**
 * 
 */
package com.bank.project.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.dto.AccountDTO;
import com.bank.project.model.Account;

/**
 * @author SUDESHA
 *
 */
@Component
public class AccountConverter {

	/**
	 * @param accountDTO
	 * @return account
	 */
	public Account convertDtoToEntity(AccountDTO accountDTO) {

		Account account = new Account();
		account.setAccountId(accountDTO.getAccountId());
		account.setAccountNo(accountDTO.getAccountNo());
		account.setBalance(accountDTO.getBalance());
		account.setOpeningDate(accountDTO.getOpeningDate());
		account.setUserId(accountDTO.getUserId());

		return account;
	}

	/**
	 * @param account
	 * @return List<AccountDTO>
	 */
	public List<AccountDTO> convertEntityToDto(List<Account> account) {
		List<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
		for (Account acc : account) {
			AccountDTO accdto = new AccountDTO();
			accdto.setAccountId(acc.getAccountId());
			accdto.setAccountNo(acc.getAccountNo());
			accdto.setBalance(acc.getBalance());
			accdto.setOpeningDate(acc.getOpeningDate());
			accdto.setUserId(acc.getUserId());

			accountDTOs.add(accdto);
		}
		return accountDTOs;
	}
}
