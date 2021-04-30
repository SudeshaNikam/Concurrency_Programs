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

import com.bank.project.converter.AccountConverter;
import com.bank.project.dao.AccountDao;
import com.bank.project.dao.UserDao;
import com.bank.project.dto.AccountDTO;
import com.bank.project.model.Account;
import com.bank.project.service.AccountService;

/**
 * @author SUDESHA
 *
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDto;

	@Autowired
	UserDao userDao;

	@Autowired
	AccountConverter accountConverter;

	@Override
	@Transactional
	public void saveAccountDetails(AccountDTO accountDTO, int userId) {
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDate);

		LocalTime localTime = LocalTime.now();
		String time = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(localTime);

		accountDTO.setUserId(userId);
		accountDTO.setOpeningDate(date + " " + time);

		Account account = accountConverter.convertDtoToEntity(accountDTO);

		accountDto.saveAccountDetails(account);
	}

	@Override
	public List<Account> getAllAccountDetails() {
		return accountDto.getAllAccountDetails();
	}

	@Override
	public List<AccountDTO> getAllAccountDetailsById(int userId) {
		List<Account> account = accountDto.getAllAccountDetailsById(userId);
		List<AccountDTO> accountDTOs = accountConverter.convertEntityToDto(account);
		return accountDTOs;
	}

	@Override
	public Account geAccountIdByFromAccNo(String fromAccountNumber) {
		return accountDto.geAccountIdByFromAccNo(fromAccountNumber);
	}

}
