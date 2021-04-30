/**
 * 
 */
package com.bank.project;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.project.dao.AccountDao;
import com.bank.project.dto.AccountDTO;
import com.bank.project.dto.TransactionDTO;
import com.bank.project.model.Account;
import com.bank.project.model.Transaction;
import com.bank.project.service.AccountService;
import com.bank.project.service.TransactionService;

/**
 * @author SUDESHA
 *
 */

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;

	@Autowired
	AccountDao accountDao;

	static Logger logger = Logger.getLogger(TransactionController.class);

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/trasactiondata/{userId}", method = RequestMethod.GET)
	public String trasactiondata(@PathVariable int userId, Model model) {
		Transaction transaction = new Transaction();
		List<AccountDTO> accountListById = accountService.getAllAccountDetailsById(userId);
		model.addAttribute("accountList", accountListById);
		model.addAttribute("transaction", transaction);
		logger.info("transaction successfully");
		return "transaction";
	}

	/**
	 * @param userId
	 * @param model
	 * @param transaction
	 * @return ModelAndView
	 * 
	 */

	@RequestMapping(value = "/trasactiondata/saveTransferAmount", method = RequestMethod.POST)
	public ModelAndView saveTransferAmount(@RequestParam int userId,
			@ModelAttribute("transaction") @Valid TransactionDTO transactionDTO, BindingResult result, Model model) {
		List<AccountDTO> accountListById = accountService.getAllAccountDetailsById(userId);
		model.addAttribute("accountList", accountListById);
		try {
			if (transactionDTO.getAmount() != 0) {
				List<String> errMessages = new ArrayList<String>();
				if (result.hasErrors()) {
					for (ObjectError err : result.getAllErrors()) {
						errMessages.add(err.getDefaultMessage());
					}
					model.addAttribute("error", errMessages);
					return new ModelAndView("transaction", "transaction", transactionDTO);
				}
			} else {
				logger.error(" accountnumber is required");
				model.addAttribute("message", "amount is required");
				return new ModelAndView("transaction");

			}

			if (transactionDTO.getFromAccountNumber() != null && transactionDTO.getToAccountNumber() != null
					&& transactionDTO.getAmount() != 0) {
				Account accountId1 = accountService.geAccountIdByFromAccNo(transactionDTO.getFromAccountNumber());
				if (transactionDTO.getFromAccountNumber().equals(transactionDTO.getToAccountNumber())) {
					logger.error("both accounts are same");
					model.addAttribute("message", "both accounts are same");
					return new ModelAndView("transaction");
				} else if (transactionDTO.getAmount() > accountId1.getBalance()) {
					logger.error("not insufficient balance");
					model.addAttribute("message", " Insufficient balance");
					return new ModelAndView("transaction");
				} else {
					logger.info("save transaction data");
					transactionService.saveTransferAmount(transactionDTO, userId);
					logger.info("Transaction successfully to " + transactionDTO.getToAccountNumber());
					return new ModelAndView("redirect:/transactionHistory?userId=" + userId);

				}
			} else {
				logger.error(" accountnumber is required");
				model.addAttribute("message", "accountnumber and amount is required");
				return new ModelAndView("transaction");
			}
		} catch (Exception e) {
			logger.error("Error while save account : " + e.getMessage(), e);
		}
		return new ModelAndView("redirect:/transactionHistory?userId=" + userId);
	}

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/transactionHistory", method = RequestMethod.GET)
	public String transactionHistory(@RequestParam int userId, Model model) {
		List<TransactionDTO> transactionHistory = transactionService.getTransactionHistory(userId);
		model.addAttribute("transaction", transactionHistory);
		logger.info("view transcation history");
		return "transactionHistory";
	}
}
