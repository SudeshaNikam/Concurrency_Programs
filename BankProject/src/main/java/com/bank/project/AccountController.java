/**
 * 
 */
package com.bank.project;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.project.dto.AccountDTO;
import com.bank.project.model.Account;
import com.bank.project.service.AccountService;

/**
 * @author SUDESHA
 *
 */

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	static Logger logger = Logger.getLogger(AccountController.class);

	/**
	 * @param userId
	 * @param model
	 * @param account
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping(value = "/accountForm/saveAccount", method = RequestMethod.POST)
	public ModelAndView saveAccount(@RequestParam int userId, @ModelAttribute("acccount") AccountDTO accountDTO,
			Model model) {
		try {
			if (accountDTO.getAccountNo().isEmpty() && accountDTO.getBalance() != 0) {
				accountService.saveAccountDetails(accountDTO, userId);
				logger.info("data account details");
			} else {
				model.addAttribute("message", " accountNo and Amount required");
				return new ModelAndView("accountForm", "account", accountDTO);
			}
		} catch (Exception e) {
			logger.error("Error while save account : " + e.getMessage(), e);
		}
		return new ModelAndView("redirect:/getAccountDetails?userId=" + userId);
	}

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/getAccountDetails", method = RequestMethod.GET)
	public String getAccountDetails(@RequestParam int userId, Model model) {
		List<AccountDTO> accountListById = accountService.getAllAccountDetailsById(userId);
		model.addAttribute("message", "Saved Account Details Successfully");
		model.addAttribute("accountList", accountListById);
		return "accountList";
	}

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/accountListdata/{userId}", method = RequestMethod.GET)
	public String accountList(@PathVariable int userId, Model model) {
		List<AccountDTO> accountListById = accountService.getAllAccountDetailsById(userId);
		model.addAttribute("accountList", accountListById);
		logger.info("view account data");
		return "accountList";
	}

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/accountForm/{userId}", method = RequestMethod.GET)
	public String accountForm(@PathVariable int userId, Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		model.addAttribute("btnValue", "Save");
		model.addAttribute("userId", userId);
		logger.info("dispaly account form");
		return "accountForm";
	}

}
